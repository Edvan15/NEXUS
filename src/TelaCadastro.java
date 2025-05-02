import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class TelaCadastro extends JFrame {

    private ArrayList<Usuario> usuarios;

    public TelaCadastro(ArrayList<Usuario> usuarios) {

        this.usuarios = usuarios;
        // Criando a janela
        setTitle("Cadastro de Usuário");
        setSize(650, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(null);

        // Criando o painel de conteúdo
        JPanel panelCadastro = new JPanel();
        panelCadastro.setBackground(new Color(2, 13, 50));
        panelCadastro.setLayout(null);
        setContentPane(panelCadastro);

        // Criando os componentes
        JLabel nexusCadastro = new JLabel("NEXUS");
        nexusCadastro.setFont(new Font("Arial", Font.BOLD, 30));
        nexusCadastro.setForeground(Color.WHITE);
        nexusCadastro.setBounds(305, 20, 200, 50);

        JLabel usuarioCadastro = new JLabel("Nome Usuário:");
        usuarioCadastro.setFont(new Font("Arial", Font.BOLD, 15));
        usuarioCadastro.setForeground(Color.WHITE);
        usuarioCadastro.setBounds(150, 90, 200, 40);

        JTextField usuarioText = new JTextField();
        usuarioText.setBounds(260, 90, 200, 40);

        JLabel senhaCadastro = new JLabel("Senha:");
        senhaCadastro.setFont(new Font("Arial", Font.BOLD, 15));
        senhaCadastro.setForeground(Color.WHITE);
        senhaCadastro.setBounds(200, 150, 200, 40);

        JPasswordField textSenha = new JPasswordField();
        textSenha.setBounds(260, 150, 200, 40);

        JLabel confirmSenha = new JLabel("Confirmar Senha:");
        confirmSenha.setFont(new Font("Arial", Font.BOLD, 15));
        confirmSenha.setForeground(Color.WHITE);
        confirmSenha.setBounds(130, 200, 200, 40);

        JPasswordField textConfirm = new JPasswordField();
        textConfirm.setBounds(260, 200, 200, 40);

        JLabel email = new JLabel("E-mail:");
        email.setFont(new Font("Arial", Font.BOLD, 15));
        email.setForeground(Color.WHITE);
        email.setBounds(200, 250, 200, 40);

        JTextField textEmail = new JTextField();
        textEmail.setBounds(260, 250, 200, 40);

        JButton salvarCadastro = new JButton("Cadastrar Conta");
        salvarCadastro.setFont(new Font("Arial", Font.BOLD, 15));
        salvarCadastro.setBounds(270, 300, 180, 30);

        salvarCadastro.addActionListener( e -> {
            String usuario = usuarioText.getText();
            String senha = new String(textSenha.getPassword());
            String confirmaSenha = new String(textConfirm.getPassword());
            String emailUsuario = textEmail.getText();

            if (usuario.isEmpty() |senha.isEmpty() || confirmaSenha.isEmpty() || emailUsuario.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Preencha todos os campos.");
            } else if (!senha.equals(confirmaSenha)) {
                JOptionPane.showMessageDialog(this, "As senhas não coincidem.");
            } else {
                usuarios.add(new Usuario(usuario, senha, emailUsuario));

                JOptionPane.showMessageDialog(this, "Usuário cadastrado com sucesso!");
                dispose();
            }
        });

        // Adicionando componentes ao painel
        panelCadastro.add(salvarCadastro);
        panelCadastro.add(textEmail);
        panelCadastro.add(email);
        panelCadastro.add(textConfirm);
        panelCadastro.add(confirmSenha);
        panelCadastro.add(textSenha);
        panelCadastro.add(senhaCadastro);
        panelCadastro.add(usuarioText);
        panelCadastro.add(usuarioCadastro);
        panelCadastro.add(nexusCadastro);


    }
    }
