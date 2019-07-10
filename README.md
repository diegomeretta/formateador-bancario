# formateador-bancario
Formateador Bancario para presentación de débitos automáticos

Si se remite un JSON con este formato al endpoint rest/credicoop/
y entrega el archivo en el formato solicitado por credicoop
{  
   "periodo":"05-2019",
   "fechaLiquidacion":"2019-02-15T00:00:00Z",
   "empresa":{  
      "codigo":"12345",
      "contacto":"Nombre del Contacto",
      "cuit":"12345678901",
      "horario":"8:00 a 15:00",
      "telefono":"011-1234-5678",
      "correoElectronico":"info@example.com",
      "nombre":"Nombre completo de la organización"
   },
   "registros":[  
      {  
         "referencia":1,
         "numeroTarjeta":"01234567890123456789012",
         "monto":123.12,
         "conceptoPago":"Alguno"
      },
      {  
         "referencia":3,
         "numeroTarjeta":"01234567890123456789013",
         "monto":234.12,
         "conceptoPago":"Otro"
      }
   ]
}