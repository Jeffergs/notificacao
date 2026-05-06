package com.jefferson.notificacao.busness;

import com.jefferson.notificacao.busness.dto.TarefasDTO;
import com.jefferson.notificacao.infraestructure.exceptions.EmailException;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;
import lombok.RequiredArgsConstructor;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;


import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;

@Service
@RequiredArgsConstructor
public class EmailService {
    private final JavaMailSender javaMailSender;
    private final TemplateEngine templateEngine;

    @Value("${envio.email.remetente}")
    public String remetente;

    @Value("${envio.email.nomeRemetente}")
    private String nomeRemetente;

    public void enviaEmail(TarefasDTO dto){
        try{
            MimeMessage mensagem = javaMailSender.createMimeMessage();
            MimeMessageHelper minmeMassageHelper = new MimeMessageHelper(mensagem,true, StandardCharsets.UTF_8.name());

            minmeMassageHelper.setFrom(new InternetAddress(remetente, nomeRemetente));
            minmeMassageHelper.setTo(InternetAddress.parse(dto.getEmailUsuario()));
            minmeMassageHelper.setSubject("Notificação de tarefa");

            Context context = new Context();
            context.setVariable("nomeTarefa", dto.getNomeTarefa());
            context.setVariable("dataEvento", dto.getDataEvento());
            context.setVariable("descricao", dto.getDescricao());
            String template = templateEngine.process("notificacao", context);
            minmeMassageHelper.setText(template,true);
            javaMailSender.send(mensagem);
        } catch (MessagingException | UnsupportedEncodingException e) {
            throw new EmailException("Erro ao enviar o email", e.getCause());
        }
    }
}
