package cl.gvidal.controller;

import cl.gvidal.DTO.CampoDto;
import cl.gvidal.model.Campo;
import cl.gvidal.model.Diio;
import cl.gvidal.salida.Mensaje;
import cl.gvidal.service.ICampoService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/campo")
@Tag(name = "Campo", description = "Endpoints para el manejo de predios agrícolas")
public class CampoController {
    @Autowired
    private ICampoService service;


    org.apache.commons.logging.Log Log = LogFactory.getLog("CampoController");

    public CampoController() {
    }

    @GetMapping("/lista/{id}")
    public ResponseEntity<?> getCampo(@PathVariable int id){
        try {
            Optional<Campo> myCampo = service.CampoById(id);

            CampoDto campoDto = CampoDto.builder()
                    .id(myCampo.get().getId())
                    .rup(myCampo.get().getRup())
                    .direccion(myCampo.get().getDireccion())
                    .build();

            return ResponseEntity.ok().body(campoDto);
        }catch (Exception e) {
            Log.info("No existe el registro: "  + id);
            return new ResponseEntity<>("Sin existencias", HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/save-campo")
    public ResponseEntity<?> saveCampo(@RequestBody Campo campo){
        Mensaje msg = new Mensaje();
        try{
            service.save(campo);
            Log.info("Se ingresa registro: "  + campo.getRup());
            msg.mensaje = "Se ingresa registro: "  + campo.getRup();
            return new ResponseEntity<Mensaje>(msg, HttpStatus.OK);
        }catch(Exception e) {
            Log.info("No es posible ingresar el registro: " + campo.getRup() + " error: " + e.getMessage());
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
