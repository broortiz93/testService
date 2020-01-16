package com.javanes.framework.model;



import java.util.Date;



public class BaseResponse{
	
	private String pMensaje;
	
	protected Date fechaCreacion;
	protected Date fechaActualiza;
	
	protected String creacion;
	protected String actualizacion;
	
	private EntityBase params;
	


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

	public EntityBase getParams() {
		return params;
	}

	public void setParams(EntityBase params) {
		this.params = params;
	}

//	public List<Usuario> getListUsuarios() {
//		return listUsuarios;
//	}
//
//	public void setListUsuarios(List<Usuario> listUsuarios) {
//		this.listUsuarios = listUsuarios;
//	}

}
