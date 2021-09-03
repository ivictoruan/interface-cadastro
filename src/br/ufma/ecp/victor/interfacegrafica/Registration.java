package br.ufma.ecp.victor.interfacegrafica;

import br.ufma.ecp.victor.user.User;
import br.ufma.ecp.victor.dao.UserDAO;

import javax.swing.*;
import java.awt.*;

public class Registration extends JFrame {

    private final JTextField txtNome;
    private final JTextField txtEmail;


    public Registration(String title) {
        super(title);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());
        setSize(300, 300);

        JPanel panNome = new JPanel(); // Painel de nome
        panNome.setLayout(new FlowLayout());
        txtNome = new JTextField(15);
        panNome.add(new JLabel("Nome"));
        panNome.add(txtNome);

        JPanel panEmail = new JPanel(); // Painel de Email
        panEmail.setLayout(new FlowLayout());
        txtEmail = new JTextField(15);
        panEmail.add(new JLabel("Email"));
        panEmail.add(txtEmail);

        JButton btnSalvar = new JButton("Salvar"); // Botão salvar

        btnSalvar.addActionListener( ( snuff ) -> {

            User user = new User( txtNome.getText(), txtEmail.getText()); // cria um user

            UserDAO dao = new UserDAO(); // cria um dao para o usuário fazer as operações de CRUD (manipular)

            dao.createUser(user);

        });

        JButton btnFechar = new JButton("Fechar"); // Botão Fechar
        btnFechar.addActionListener( ( e ) ->
                System.exit(0)
        ); // notação lambda: ( coisa ) -> Classe.metodo();

        add(panNome);
        add(panEmail);
        add(btnSalvar);
        add(btnFechar);
    }
}
