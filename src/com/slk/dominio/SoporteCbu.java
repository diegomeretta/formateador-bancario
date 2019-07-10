package com.slk.dominio;

import java.math.BigDecimal;

public class SoporteCbu {

	private Integer referencia;
	private String numeroTarjeta;
	private BigDecimal monto;
	private String conceptoPago;

	private SoporteCbu() {
	}

	public SoporteCbu(Integer referencia, String numeroTarjeta, BigDecimal monto, String conceptoPago) {
		this();
		this.referencia = referencia;
		this.numeroTarjeta = numeroTarjeta;
		this.monto = monto;
		this.conceptoPago = conceptoPago;
	}

	public Integer getReferencia() {
		return referencia;
	}

	public String getNumeroTarjeta() {
		return numeroTarjeta;
	}

	public BigDecimal getMonto() {
		return monto;
	}

	public String getConceptoPago() {
		return conceptoPago;
	}
}