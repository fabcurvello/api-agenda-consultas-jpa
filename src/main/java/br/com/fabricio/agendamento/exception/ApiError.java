package br.com.fabricio.agendamento.exception;

import java.time.LocalDateTime;
import java.util.Map;

public class ApiError {

    private LocalDateTime timestamp;
    private int status;
    private String erro;
    private String mensagem;
    
    private Map<String, String> campos;

    public ApiError() {
    }

    public ApiError(LocalDateTime timestamp, int status, String erro, String mensagem) {
        this.timestamp = timestamp;
        this.status = status;
        this.erro = erro;
        this.mensagem = mensagem;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getErro() {
        return erro;
    }

    public void setErro(String erro) {
        this.erro = erro;
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }
    
    public Map<String, String> getCampos() {
        return campos;
    }
    
    public void setCampos(Map<String, String> campos) {
        this.campos = campos;
    }

}