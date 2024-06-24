package cl.gvidal.controller;

import cl.gvidal.DTO.FichaDto;
import cl.gvidal.decoradordiio.FichaDec;
import cl.gvidal.decoradordiio.Receta;
import cl.gvidal.decoradordiio.decorador.DecoradorAntibiotico;
import cl.gvidal.model.Diio;
import cl.gvidal.model.Ficha;
import cl.gvidal.salida.Mensaje;
import cl.gvidal.service.IDiioService;
import cl.gvidal.service.IFichaService;
import cl.gvidal.strategydiio.CalcDosis;
import cl.gvidal.strategydiio.Context;
import cl.gvidal.strategydiio.DosisStrategy;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/fichas")
@CrossOrigin(origins = "*",
        methods= {
                RequestMethod.GET,
                RequestMethod.POST,
                RequestMethod.PUT,
                RequestMethod.DELETE
        })
public class AtencionController {

    @Autowired
    private IFichaService fichaService;
    @Autowired
    private IDiioService diioService;

    Log Log = LogFactory.getLog("AtencionController");

/*    {
        "fechaAtencion": "2024/01/01",
        "medicamento": "Vacaprofeno",
        "indicacion": "Administrar medicamento 2 veces al dia durante 5 dias",
        "veterinario": "Juan Perez Cotapos",
        "diio" : {
        "id": 1
        }
    }
*/
    @PostMapping("/atencion")
    public ResponseEntity<?> saveCow(@RequestBody Ficha ficha, @RequestParam int peso){
        Mensaje msg = new Mensaje();
        Diio diio = new Diio();
        CalcDosis calc = new CalcDosis();
        DosisStrategy dosisStrategy = calc.getStrategy(peso);
        Context context = new Context(dosisStrategy);
        Receta fichaDecorada = new FichaDec("Antibiotico","Administrar " + ficha.getTratamiento() + " " + Integer.toString(context.executeStrategy(peso)) + "Ml");
        DecoradorAntibiotico decoradorAntibiotico = new DecoradorAntibiotico(fichaDecorada);

        ficha.setTratamiento(decoradorAntibiotico.getObservaciones());
        String nroDiioFicha = ficha.getDiio().getNroDiio();

        try{
            Diio diioFicha = (Diio) diioService.listarPorNroDiio(nroDiioFicha);
            ficha.setDiio(diioFicha);
            ficha.setFechaAtencion(ficha.getFechaAtencion().substring(0,10));
            fichaService.save(ficha);
            diio = diioService.listarId(ficha.getDiio().getId());
            Log.info("Se ingresa registro: "  + diio.getNroDiio());
            msg.mensaje = "Se registra atención para el diio: "  + diio.getNroDiio();
            return new ResponseEntity<Mensaje>(msg, HttpStatus.OK);
        }catch(Exception e) {
            msg.mensaje = "No es posible ingresar el registro: " + diio.getNroDiio() + " error: " + e.getMessage();
            Log.info("No es posible ingresar el registro: " + diio.getNroDiio() + " error: " + e.getMessage());
            return new ResponseEntity<Mensaje>(msg, HttpStatus.INTERNAL_SERVER_ERROR);

        }
    }

    @GetMapping("/lista")
    public ResponseEntity<?> getFichas() {
        Mensaje msg = new Mensaje();
        List<FichaDto> listaDto = new ArrayList<>();
        try {
            List<Ficha> lista = fichaService.listar();
            for(Ficha ficha : lista) {
                FichaDto fichaDto = new FichaDto(
                        ficha.getId()
                        ,ficha.getFechaAtencion()
                        ,ficha.getDiagnostico()
                        ,ficha.getTratamiento()
                        ,ficha.getVeterinario()
                        ,ficha.getDiio().getNroDiio()
                );
                listaDto.add(fichaDto);
            }
            return new ResponseEntity<List<FichaDto>>(listaDto, HttpStatus.OK);

        } catch (Exception e) {
            msg.mensaje = "Error al consultar datos ... "  + e.getMessage();
            Log.info("Error al consultar datos ... " + e.getMessage() + "Método: getFichas");
            return new ResponseEntity<Mensaje>(msg, HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/lista/{id}")
    public ResponseEntity<?> getFicha(@PathVariable int id) {
        Mensaje msg = new Mensaje();
        try {
            //Optional<Ficha> ficha = fichaService.fichaPorId(id);
            //int idDiio = ficha.get().getDiio().getId();// capturo el id del dio... para ir a buscar todas las atenciones de esa vaca
            List<FichaDto> listaDto = new ArrayList<>();

            try {
                List<Ficha> lista = fichaService.listarPorDiio(id);
                for(Ficha fichaDiio : lista) {
                    FichaDto fichaDto = new FichaDto(
                            fichaDiio.getId()
                            ,fichaDiio.getFechaAtencion()
                            ,fichaDiio.getDiagnostico()
                            ,fichaDiio.getTratamiento()
                            ,fichaDiio.getVeterinario()
                            ,fichaDiio.getDiio().getNroDiio()
                    );
                    listaDto.add(fichaDto);
                }
                return new ResponseEntity<List<FichaDto>>(listaDto, HttpStatus.OK);

            } catch (Exception e) {
                msg.mensaje = "Error al consultar datos ... "  + e.getMessage();
                Log.info("Error al consultar datos ... " + e.getMessage());
                return new ResponseEntity<>("Sin existencias", HttpStatus.NOT_FOUND);
            }

        } catch (Exception e) {
            msg.mensaje = "Error al consultar datos ... "  + e.getMessage();
            Log.info("Error al consultar datos ... " + e.getMessage());
            return new ResponseEntity<Mensaje>(msg, HttpStatus.NOT_FOUND);
        }
    }
}
