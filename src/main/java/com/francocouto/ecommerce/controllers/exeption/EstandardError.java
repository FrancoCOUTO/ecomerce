package com.francocouto.ecommerce.controllers.exeption;

import java.time.Instant;

public class EstandardError {

	private Instant time; 
	private Integer status;
	private String erro;
	private String mensagem;
	private String path;
	
	public EstandardError() {
		
	}
	
	public EstandardError(Instant time, Integer status, String erro, String mensagem, String path) {
		this.time = time;
		this.status = status;
		this.erro = erro;
		this.mensagem = mensagem;
		this.path = path;
	}

	public Instant getTime() {
		return time;
	}

	public void setTime(Instant time) {
		this.time = time;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getMensagem() {
		return mensagem;
	}

	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public String getErro() {
		return erro;
	}

	public void setErro(String erro) {
		this.erro = erro;
	}
	
	
	
}
