package com.slk.controlador;

import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Formatter;
import java.util.List;

import com.slk.dominio.Presentacion;
import com.slk.dominio.SoporteCbu;

public class CredicoopMainFormater {

	private static final String CODIGO_REGISTRO = "51";
	private static final String IDENTIFICADOR2 = "                ";
	private static final String MONEDA = "P";

	StringBuffer sb;
	Presentacion presentacion;
	DateFormat df = new SimpleDateFormat("yyMMdd");

	public CredicoopMainFormater(StringBuffer sb, Presentacion datos) {
		this.sb = sb;
		this.presentacion = datos;
	}

	public void getRegistros() {
		List<SoporteCbu> registros = presentacion.getRegistros();
		for (SoporteCbu soporteCbu : registros) {
			sb.append(soporteCbu.getNumeroTarjeta().substring(0, 3) + CODIGO_REGISTRO
					+ df.format(presentacion.getFechaLiquidacion()) + presentacion.getEmpresa().getCodigo()
					+ IDENTIFICADOR(soporteCbu.getReferencia()) + IDENTIFICADOR2 + MONEDA
					+ soporteCbu.getNumeroTarjeta() + IMPORTE(soporteCbu.getMonto())
					+ presentacion.getEmpresa().getCuit() + CONCEPTO_PAGO(soporteCbu.getConceptoPago()) + PERIODO()
					+ "\r\n");
		}
	}

	private String IDENTIFICADOR(Integer referencia) {
		Formatter f = new Formatter(new StringBuffer(""));
		f.format("%1$06d", referencia);
		String string = f.out().toString();
		f.close();
		return string;
	}

	private String IMPORTE(BigDecimal importe) {
		Formatter f = new Formatter(new StringBuffer(""), null);
		f.format("%1$010d", importe.multiply(new BigDecimal(100)).intValue());
		String resultado = f.out().toString();
		f.close();
		return resultado;
	}

	private String CONCEPTO_PAGO(String conceptoPago) {
		return String.format("%1$-" + 10 + "s", conceptoPago);
	}

	private String PERIODO() {
		return String.format("%1$" + 14 + "s", presentacion.getPeriodo());
	}
}
