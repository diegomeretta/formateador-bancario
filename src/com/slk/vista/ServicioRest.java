package com.slk.vista;

import java.io.IOException;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import com.slk.controlador.Controlador;
import com.slk.controlador.CredicoopMainFormater;
import com.slk.dominio.Presentacion;

@RestController
@RequestMapping("/")
public class ServicioRest {

	{
		System.out.println("Servicio REST funcional");
	}

	@RequestMapping(value = "/credicoop/", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<String> obtenerDatos() throws IOException {

		String json = Controlador.obtenerJsonEjemplo();
		Gson g = new Gson();
		Presentacion presentacion = g.fromJson(json, Presentacion.class);

		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.parseMediaType("text/plain"));
		String outputFilename = "MAIN" + presentacion.getEmpresa().getCodigo().substring(0, 3) + ".TXT";
		headers.setContentDispositionFormData(outputFilename, outputFilename);
		headers.setCacheControl("must-revalidate, post-check=0, pre-check=0");

		StringBuffer sb = new StringBuffer();
		CredicoopMainFormater credicoopMainFomater = new CredicoopMainFormater(sb, presentacion);
		credicoopMainFomater.getRegistros();

		return new ResponseEntity<String>(sb.toString(), HttpStatus.OK);
	};
}
