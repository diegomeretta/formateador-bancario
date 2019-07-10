package com.slk.dominio;

import java.util.Date;
import java.util.List;

public class Presentacion {

	private String periodo;
	private Date fechaLiquidacion;
	private Empresa empresa;
	private List<SoporteCbu> registros;

	public String getPeriodo() {
		return periodo;
	}

	public void setPeriodo(String periodo) {
		this.periodo = periodo;
	}

	public Date getFechaLiquidacion() {
		return fechaLiquidacion;
	}

	public void setFechaLiquidacion(Date fechaLiquidacion) {
		this.fechaLiquidacion = fechaLiquidacion;
	}

	public Empresa getEmpresa() {
		return empresa;
	}

	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}

	public List<SoporteCbu> getRegistros() {
		return registros;
	}

	public void setRegistros(List<SoporteCbu> registros) {
		this.registros = registros;
	}
}
