import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Login {
    public static void main(String[] args) {

        ArrayList<Usuario> usuarios = new ArrayList<>();
        //Tela de Login
        JFrame Login = new JFrame("Tela Usuário");
        Login.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Login.setSize(650, 400);
        Login.setLocationRelativeTo(null);
        Login.setLayout(null);

        JPanel panel = new JPanel();
        panel.setBackground(new Color(2, 13, 50));
        panel.setLayout(null);
        Login.setContentPane(panel);

        ImageIcon originalIcon = new ImageIcon(Login.class.getResource("/imagens/nexuslogo.png"));

        Image imagemRedimensionada = originalIcon.getImage().getScaledInstance(200, 150, Image.SCALE_SMOOTH);
        ImageIcon iconReduzido = new ImageIcon(imagemRedimensionada);
        JLabel label = new JLabel(iconReduzido);
        label.setBounds(260, 30, 200, 75);


        JLabel login = new JLabel("Login:");
        login.setFont(new Font("Arial", Font.BOLD, 20));
        login.setForeground(Color.WHITE);
        login.setBounds(190, 100, 200, 50);

        JTextField loginText = new JTextField();
        loginText.setBounds(260, 100, 200, 40);

        JLabel password = new JLabel("Senha:");
        password.setFont(new Font("Arial", Font.BOLD, 20));
        password.setForeground(Color.WHITE);
        password.setBounds(185, 160, 200, 40);

        JPasswordField senhaText = new JPasswordField();
        senhaText.setBounds(260, 160, 200, 40);

        JButton logar = new JButton("Logar");
        logar.setFont(new Font("Arial", Font.BOLD, 15));
        logar.setBounds(250, 220, 90, 30);

        JLabel cadastre = new JLabel("Já tem login ? Se não cadastre-se acima!");
        cadastre.setFont(new Font("Arial", Font.BOLD, 15));
        cadastre.setForeground(Color.WHITE);
        cadastre.setBounds(215, 252, 300, 40);

        JButton cadastrar = new JButton("Cadastrar");
        cadastrar.setFont(new Font("Arial", Font.BOLD, 15));
        cadastrar.setBounds(350, 220, 120, 30);


        Login.add(cadastre);
        Login.add(cadastrar);
        Login.add(logar);
        Login.add(senhaText);
        Login.add(password);
        Login.add(loginText);
        Login.add(login);
        Login.setVisible(true);
        panel.add(label);
        login.setVisible(true);

        //Caminho para tela do Nexus Bem Vindo apos aperta o botão LOGAR
        logar.addActionListener(e -> {
            String usuario = loginText.getText();
            String senhaUsuario = new String(senhaText.getPassword());

            if (usuario.isEmpty() ||senhaUsuario.isEmpty()) {
                JOptionPane.showMessageDialog(login, "Preencha todos os campos.");
            } else {
                boolean encontrou = false;

                for (Usuario u : usuarios) {

                    if (u.getNome().equals(usuario) && u.getSenha().equals(senhaUsuario)) {
                        encontrou = true;
                        break;
                    }
                }
                if (encontrou) {
                    TelaLogin telaLogin = new TelaLogin();
                    telaLogin.setVisible(true);
                } else {
                    JOptionPane.showMessageDialog(null, "Usuário ou senha incorretos.");
                }
            }
        });


        //Tela de cadastro apos o botão ser apertado CADASTRAR
        cadastrar.addActionListener(e -> {
            TelaCadastro TelaCadastro = new TelaCadastro(usuarios);
            TelaCadastro.setVisible(true);
        });

    }
}
