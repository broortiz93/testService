package com.javanes.framework.model;


public class PagoServicio extends Base {
	
 private String pEmpresa;
 private String pSucursal; 
 private String pUsuario;
 private String pTransCargo;
 private String pTransAbono;
 private String pTransSuc;
 private String pFolioSuc;
 private String pNumCtaOrigen;
 private String pNumCtaDestino;
 private Integer pCheque;
 private Number pMonto;
 private Number pMoneda;
 private String pReferencia;
 private String pNumTarjetaOrigen;
 private String pNumTarjetaDestino;
 private String pUsuAutoriza;
 private Number pMontoTotal;
 private Number pMontoFirme;
 private Number pMontoSBC;
 private Number pMontoRem;
 private Integer pDiasRet;
 private Integer pDocto;
 private String pCategoria;
 private String pConvenio;
 private String cRefTelefono;
 private String cRefVerificador;
 private String cFormaPago;
 private String cCuentaCargo;
 private String cTransaccSuc;
 private String dFechaPago;
 
 //ObtenerParametro
 private Integer cuentaServicio;
//ObtieneNumerTransferencia
 private String operacionServicio;
 
 public String getpEmpresa() {
	return pEmpresa;
}
public void setpEmpresa(String pEmpresa) {
	this.pEmpresa = pEmpresa;
}
public String getpSucursal() {
	return pSucursal;
}
public void setpSucursal(String pSucursal) {
	this.pSucursal = pSucursal;
}
public String getpUsuario() {
	return pUsuario;
}
public void setpUsuario(String pUsuario) {
	this.pUsuario = pUsuario;
}
public String getpTransCargo() {
	return pTransCargo;
}
public void setpTransCargo(String pTransCargo) {
	this.pTransCargo = pTransCargo;
}
public String getpTransAbono() {
	return pTransAbono;
}
public void setpTransAbono(String pTransAbono) {
	this.pTransAbono = pTransAbono;
}
public String getpTransSuc() {
	return pTransSuc;
}
public void setpTransSuc(String pTransSuc) {
	this.pTransSuc = pTransSuc;
}
public String getpFolioSuc() {
	return pFolioSuc;
}
public void setpFolioSuc(String pFolioSuc) {
	this.pFolioSuc = pFolioSuc;
}
public String getpNumCtaOrigen() {
	return pNumCtaOrigen;
}
public void setpNumCtaOrigen(String pNumCtaOrigen) {
	this.pNumCtaOrigen = pNumCtaOrigen;
}
public String getpNumCtaDestino() {
	return pNumCtaDestino;
}
public void setpNumCtaDestino(String pNumCtaDestino) {
	this.pNumCtaDestino = pNumCtaDestino;
}
public Integer getpCheque() {
	return pCheque;
}
public void setpCheque(Integer pCheque) {
	this.pCheque = pCheque;
}
public Number getpMonto() {
	return pMonto;
}
public void setpMonto(Number pMonto) {
	this.pMonto = pMonto;
}
public Number getpMoneda() {
	return pMoneda;
}
public void setpMoneda(Number pMoneda) {
	this.pMoneda = pMoneda;
}
public String getpReferencia() {
	return pReferencia;
}
public void setpReferencia(String pReferencia) {
	this.pReferencia = pReferencia;
}
public String getpNumTarjetaOrigen() {
	return pNumTarjetaOrigen;
}
public void setpNumTarjetaOrigen(String pNumTarjetaOrigen) {
	this.pNumTarjetaOrigen = pNumTarjetaOrigen;
}
public String getpNumTarjetaDestino() {
	return pNumTarjetaDestino;
}
public void setpNumTarjetaDestino(String pNumTarjetaDestino) {
	this.pNumTarjetaDestino = pNumTarjetaDestino;
}
public String getpUsuAutoriza() {
	return pUsuAutoriza;
}
public void setpUsuAutoriza(String pUsuAutoriza) {
	this.pUsuAutoriza = pUsuAutoriza;
}
public Number getpMontoTotal() {
	return pMontoTotal;
}
public void setpMontoTotal(Number pMontoTotal) {
	this.pMontoTotal = pMontoTotal;
}
public Number getpMontoFirme() {
	return pMontoFirme;
}
public void setpMontoFirme(Number pMontoFirme) {
	this.pMontoFirme = pMontoFirme;
}
public Number getpMontoSBC() {
	return pMontoSBC;
}
public void setpMontoSBC(Number pMontoSBC) {
	this.pMontoSBC = pMontoSBC;
}
public Number getpMontoRem() {
	return pMontoRem;
}
public void setpMontoRem(Number pMontoRem) {
	this.pMontoRem = pMontoRem;
}
public Integer getpDiasRet() {
	return pDiasRet;
}
public void setpDiasRet(Integer pDiasRet) {
	this.pDiasRet = pDiasRet;
}
public Integer getpDocto() {
	return pDocto;
}
public void setpDocto(Integer pDocto) {
	this.pDocto = pDocto;
}
public String getpCategoria() {
	return pCategoria;
}
public void setpCategoria(String pCategoria) {
	this.pCategoria = pCategoria;
}
public String getpConvenio() {
	return pConvenio;
}
public void setpConvenio(String pConvenio) {
	this.pConvenio = pConvenio;
}
public String getcRefTelefono() {
	return cRefTelefono;
}
public void setcRefTelefono(String cRefTelefono) {
	this.cRefTelefono = cRefTelefono;
}
public String getcRefVerificador() {
	return cRefVerificador;
}
public void setcRefVerificador(String cRefVerificador) {
	this.cRefVerificador = cRefVerificador;
}
public String getcFormaPago() {
	return cFormaPago;
}
public void setcFormaPago(String cFormaPago) {
	this.cFormaPago = cFormaPago;
}
public String getcCuentaCargo() {
	return cCuentaCargo;
}
public void setcCuentaCargo(String cCuentaCargo) {
	this.cCuentaCargo = cCuentaCargo;
}
public String getcTransaccSuc() {
	return cTransaccSuc;
}
public void setcTransaccSuc(String cTransaccSuc) {
	this.cTransaccSuc = cTransaccSuc;
}
public String getdFechaPago() {
	return dFechaPago;
}
public void setdFechaPago(String dFechaPago) {
	this.dFechaPago = dFechaPago;
}
public String getOperacionServicio() {
	return operacionServicio;
}
public void setOperacionServicio(String operacionServicio) {
	this.operacionServicio = operacionServicio;
}
public Integer getCuentaServicio() {
	return cuentaServicio;
}
public void setCuentaServicio(Integer cuentaServicio) {
	this.cuentaServicio = cuentaServicio;
}
}