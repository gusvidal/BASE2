package cl.gvidal.controller;

import java.util.ArrayList;
import java.util.List;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import cl.gvidal.DTO.DiioDto;
import cl.gvidal.model.Diio;
import cl.gvidal.salida.Mensaje;
import cl.gvidal.service.IDiioService;

@RestController
@RequestMapping("/diio")
@CrossOrigin(origins = "*", 
methods= {
    RequestMethod.GET,
    RequestMethod.POST, 
    RequestMethod.PUT, 
    RequestMethod.DELETE
})
@Tag(name = "Diio", description = "Endpoints para el manejo de animales areteados")
public class DiioController {

    @Autowired
    private IDiioService service;

    Log Log = LogFactory.getLog("DiioController");

	public DiioController() {
	}

    @GetMapping("/lista/{id}")
    public ResponseEntity<?> getDiio(@PathVariable int id){
    	try {
        Diio arete = service.listarId(id);
        DiioDto diioDto = new DiioDto(
        		arete.getId(),
        		arete.getNroDiio(),
        		arete.getFechaInstall(),
        		arete.getDesc(),
        		arete.getFechaNacimiento(),
        		arete.getCampo().getId(),
        		arete.getCampo().getDireccion(),
        		arete.getCampo().getRup()
        		);
        return ResponseEntity.ok().body(diioDto);
    	}catch (Exception e) {
    		Log.info("No existe el registro: "  + id);
    		return new ResponseEntity<>("Sin existencias", HttpStatus.NOT_FOUND);
        }
    }

    /* De esta manera lo llamamos en postman
     * Creando primero el registro en la tabla campo
     {
    "nroDiio": "01.365.9866",
    "fechaInstall": "2023/05/01",
    "desc": "Vaquilla angus negro",
    "fechaNacimiento": "2022/10/21",
    "campo": {
        "id": 1,
        "rup": "10.1.01.2568",
        "direccion": "Planchado los indios KM 1"
    }
}
     * */
    @PostMapping("/nuevo-diio")
    public ResponseEntity<?> saveCow(@RequestBody Diio vaca){
        Mensaje msg = new Mensaje();
        try{
            service.save(vaca);
			Log.info("Se ingresa registro: "  + vaca.getNroDiio());
			msg.mensaje = "Se ingresa registro: "  + vaca.getNroDiio();
            return new ResponseEntity<Mensaje>(msg, HttpStatus.OK);
        }catch(Exception e) {
            Log.info("No es posible ingresar el registro: " + vaca.getNroDiio() + " error: " + e.getMessage());
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
	
	@PutMapping("/update/{id}")
	public ResponseEntity<?> updateCow(@PathVariable("id") int id, @RequestBody Diio vaca) {
		Mensaje msg = new Mensaje();
		try {
			Diio animal = new Diio();
			Log.info("Se ha CREADO un objeto del tipo Diio");
			animal.setId(id);
			animal.setFechaInstall(vaca.getFechaInstall());
			animal.setDesc(vaca.getDesc());
			animal.setFechaNacimiento(vaca.getFechaNacimiento());
			animal.setNroDiio(vaca.getNroDiio());
			animal.setCampo(vaca.getCampo());
			service.save(animal);
			Log.info("Se ha actualizado el registro id : " + id);
			msg.mensaje = "Actualizacion de datos con exito!!";
			return new ResponseEntity<Mensaje>(msg, HttpStatus.OK);
		} catch (Exception e) {
			Log.info("No es posible actualizar el registro : " + id + " error: " + e.getMessage());
			return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	 

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteCow(@PathVariable("id") int id) {
        Mensaje msg = new Mensaje();
		try{
			service.delete(id);
			Log.info("Se elimino la vaca con id : " + id);
            msg.mensaje = "Registro eliminado con exito!!";
            
            return new ResponseEntity<Mensaje>(msg, HttpStatus.OK);
        } catch(Exception e) {
            Log.info("No es posible eliminar el registro : " + id + " error: " + e.getMessage());
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
	}

    @GetMapping("/lista") 
	public ResponseEntity<?> getTodos() {
		List<DiioDto> listaDto = new ArrayList<>();

		try {
			List<Diio> lista = service.listar();
			for(Diio diio : lista) {
				//DiioDto diioDto = new DiioDto();
				DiioDto diioDto = new DiioDto(
						diio.getId(),
						diio.getNroDiio(),
						diio.getFechaInstall(),
						diio.getDesc(),
						diio.getFechaNacimiento(),
						diio.getCampo().getId(),
						diio.getCampo().getDireccion(),
						diio.getCampo().getRup());
				listaDto.add(diioDto);
			}
			return new ResponseEntity<List<DiioDto>>(listaDto, HttpStatus.OK);
			
		} catch (Exception e) {
    		Log.info("Error al consultar datos ... " + e.getMessage());
    		return new ResponseEntity<>("Sin existencias", HttpStatus.NOT_FOUND);
        }
	}

	@Operation(
			summary = "Get a paginated Diio list",
			description = "This method provide a paginated Diio list ")
	@ApiResponses(
			value = {
					@ApiResponse(
							responseCode = "200",
							description = "Diio list found in the database, response the diio info",
							content = {
									@Content(
											mediaType = "application/json",
											schema = @Schema(implementation = Diio.class))}
					),
					@ApiResponse(
							responseCode = "404",
							description = "Diio list not found",
							content = {@Content}
					)
			}
	)
	@GetMapping("/lista-page/{page}")
	public ResponseEntity<?> getTodosPaginados(@PathVariable("page") int page) {
		List<DiioDto> listaDto = new ArrayList<>();

		try {
			List<Diio> lista = service.listAllPage(page);
			for(Diio diio : lista) {
				//DiioDto diioDto = new DiioDto();
				DiioDto diioDto = new DiioDto(
						diio.getId(),
						diio.getNroDiio(),
						diio.getFechaInstall(),
						diio.getDesc(),
						diio.getFechaNacimiento(),
						diio.getCampo().getId(),
						diio.getCampo().getDireccion(),
						diio.getCampo().getRup());
				listaDto.add(diioDto);
			}
			return new ResponseEntity<List<DiioDto>>(listaDto, HttpStatus.OK);

		} catch (Exception e) {
			Log.info("Error al consultar datos ... " + e.getMessage());
			return new ResponseEntity<>("Sin existencias", HttpStatus.NOT_FOUND);
		}
	}
}
