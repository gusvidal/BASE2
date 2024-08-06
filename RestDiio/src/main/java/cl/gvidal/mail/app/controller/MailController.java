package cl.gvidal.mail.app.controller;

import cl.gvidal.mail.app.model.MailModel;
import cl.gvidal.mail.service.MailService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/mail")
@Tag(name = "Mail", description = "Endpoints el envío de e-mails")
public class MailController {

    @Autowired
    MailService mailService;

    @Operation(summary = "Send a generic mail", description = "Send a message mail", tags = { "Mail" })
    //@Parameter(in= ParameterIn.HEADER, description = "Authorization token", name = "X-Auth-Token", content = @Content(schema = @Schema(type = "string")))
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Correo enviado con exito",
                    content = @Content(schema = @Schema(implementation = MailService.class))),
            @ApiResponse(responseCode = "400", description = "Error en el envio de correo", content = @Content)
    })
    @PostMapping("/send")
    public ResponseEntity<Object>sendMail(@RequestBody MailModel mailModel){
        mailService.sendMessageUser(mailModel.subject, mailModel.mailTo,mailModel.body);
        return ResponseEntity.ok().body("El e-mail fue enviado con éxito!!");
    }
}