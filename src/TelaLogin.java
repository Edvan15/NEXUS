import javax.swing.*;
import java.awt.*;

public class TelaLogin  extends JFrame {
        public TelaLogin() {
        // Criando a janela
        setTitle("Menu");
        setSize(650, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(null);

        // Criando o painel
        JPanel panel2 = new JPanel();
        panel2.setBackground(new Color(2, 13, 50));
        panel2.setLayout(null);
        setContentPane(panel2);

        // Criando os componentes
        JLabel Nexus = new JLabel("Bem vindo ao Nexus");
        Nexus.setFont(new Font("Arial", Font.BOLD, 30));
        Nexus.setForeground(Color.WHITE);
        Nexus.setBounds(200, 20, 400, 50);

        JLabel url = new JLabel("Digite uma URL:");
        url.setFont(new Font("Arial", Font.BOLD, 20));
        url.setForeground(Color.WHITE);
        url.setBounds(280, 80, 200, 40);

        JTextField urlText = new JTextField();
        urlText.setBounds(200, 120, 300, 30);

        JButton salvarUrl = new JButton("Salvar");
        salvarUrl.setBounds(300, 160, 90, 30);

        JButton editar = new JButton("Editar");
        editar.setBounds(250, 310, 90, 30);

        JButton excluir = new JButton("Excluir");
        excluir.setBounds(350, 310, 90, 30);

        // Criando a lista e o JScrollPane
        DefaultListModel<String> model = new DefaultListModel<>();
        JList<String> list = new JList<>(model);
        JScrollPane scroll = new JScrollPane(list);
        scroll.setBounds(200, 200, 300, 100);

        // Ação do botão Salvar
        salvarUrl.addActionListener(e1 -> {
            String urlInserida = urlText.getText();
            if (!urlInserida.isEmpty()) {
                model.addElement(urlInserida);
                urlText.setText("");
            }
        });

        // Ação do botão Editar
        editar.addActionListener(e1 -> {
            int index = list.getSelectedIndex();
            if (index >= 0) {
                String novoTexto = JOptionPane.showInputDialog("Editar:", model.get(index));
                if (novoTexto != null && !novoTexto.trim().isEmpty()) {
                    model.set(index, novoTexto);
                }
            }
        });

        // Ação do botão Excluir
        excluir.addActionListener(e1 -> {
            int index = list.getSelectedIndex();
            if (index >= 0) {
                model.remove(index);
            }
        });

        // Adicionando os componentes ao painel
        panel2.add(Nexus);
        panel2.add(url);
        panel2.add(urlText);
        panel2.add(salvarUrl);
        panel2.add(editar);
        panel2.add(excluir);
        panel2.add(scroll);

        // Tornando a janela visível
    }
}