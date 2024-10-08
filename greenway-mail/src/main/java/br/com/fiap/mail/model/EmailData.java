package br.com.fiap.mail.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EmailData {

    private String from;
    private String to;
    private String subject;
    private String body;

}
