package com.javanes.framework.model;

import java.util.Date;


public class Base {

	private static final long serialVersionUID = 1L;
	private String pCodRetorno;
	private String pMensaje;
	
	protected Date fechaCreacion;
	protected Date fechaActualiza;
	
	protected String creacion;
	protected String actualizacion;
	public String getpCodRetorno() {
		return pCodRetorno;
	}
	public void setpCodRetorno(String pCodRetorno) {
		this.pCodRetorno = pCodRetorno;
	}
	public String getpMensaje() {
		return pMensaje;
	}
	public void setpMensaje(String pMensaje) {
		this.pMensaje = pMensaje;
	}
	public Date getFechaCreacion() {
		return fechaCreacion;
	}
	public void setFechaCreacion(Date fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}
	public Date getFechaActualiza() {
		return fechaActualiza;
	}
	public void setFechaActualiza(Date fechaActualiza) {
		this.fechaActualiza = fechaActualiza;
	}
	public String getCreacion() {
		return creacion;
	}
	public void setCreacion(String creacion) {
		this.creacion = creacion;
	}
	public String getActualizacion() {
		return actualizacion;
	}
	public void setActualizacion(String actualizacion) {
		this.actualizacion = actualizacion;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
	
	
}
