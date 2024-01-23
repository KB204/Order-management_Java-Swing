package commandes;

import javax.swing.*;
import java.awt.*;
import java.time.DateTimeException;
import java.time.LocalDate;

public class GestionCommandeGUI extends JFrame {

    private static final long serialVersionUID = 1L;
    private JTextField clientIdField, clientNameField, clientAddressField, clientTelField;
    private JTextField orderIdField, orderDayField, orderMonthField, orderYearField, orderTypeField, orderStatusField;
    private JTextField productIdField, productNameField, productPriceField, productStockField, productQuantityField, productReductionField;
    private JTextArea outputTextArea;

    public GestionCommandeGUI() {
        initializeUI();
    }

    private void initializeUI() {
        setTitle("Gestion des Commandes");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        JPanel clientInputPanel = createClientInputPanel();
        clientInputPanel.setBorder(BorderFactory.createTitledBorder("Informations du Client"));

        JPanel orderInputPanel = createOrderInputPanel();
        orderInputPanel.setBorder(BorderFactory.createTitledBorder("Informations de la Commande"));

        JPanel productInputPanel = createProductInputPanel();
        productInputPanel.setBorder(BorderFactory.createTitledBorder("Informations du Produit"));

        JButton addButton = new JButton("Ajouter une Commande");
        addButton.addActionListener(e -> handleAddClientAndOrderButton());

        outputTextArea = new JTextArea(15, 30);
        outputTextArea.setEditable(false);

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(addButton);

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));

        mainPanel.add(clientInputPanel);
        mainPanel.add(orderInputPanel);
        mainPanel.add(productInputPanel);
        mainPanel.add(buttonPanel);
        mainPanel.add(new JScrollPane(outputTextArea));

        add(mainPanel, BorderLayout.CENTER);

        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }


    private JPanel createClientInputPanel() {
        JPanel panel = new JPanel(new GridLayout(4, 2));

        JLabel clientIdLabel = new JLabel("Entrez l'identifiant du client:");
        clientIdField = new JTextField();

        JLabel clientNameLabel = new JLabel("Entrez le nom et prénom du client:");
        clientNameField = new JTextField();

        JLabel clientAddressLabel = new JLabel("Entrez l'adresse du client:");
        clientAddressField = new JTextField();

        JLabel clientTelLabel = new JLabel("Entrez le numéro de téléphone du client:");
        clientTelField = new JTextField();

        panel.add(clientIdLabel);
        panel.add(clientIdField);

        panel.add(clientNameLabel);
        panel.add(clientNameField);

        panel.add(clientAddressLabel);
        panel.add(clientAddressField);

        panel.add(clientTelLabel);
        panel.add(clientTelField);

        return panel;
    }

    private JPanel createOrderInputPanel() {
        JPanel panel = new JPanel(new GridLayout(6, 2));

        JLabel orderIdLabel = new JLabel("Entrez le numéro de commande:");
        orderIdField = new JTextField();

        JLabel orderDayLabel = new JLabel("Entrez le jour de la commande:");
        orderDayField = new JTextField();

        JLabel orderMonthLabel = new JLabel("Entrez le mois de la commande:");
        orderMonthField = new JTextField();

        JLabel orderYearLabel = new JLabel("Entrez l'année de la commande:");
        orderYearField = new JTextField();

        JLabel orderTypeLabel = new JLabel("Entrez le type de commande (express ou normal):");
        orderTypeField = new JTextField();

        JLabel orderStatusLabel = new JLabel("Entrez le statut du paiement (0 pour non payé, 1 pour payé):");
        orderStatusField = new JTextField();

        panel.add(orderIdLabel);
        panel.add(orderIdField);

        panel.add(orderDayLabel);
        panel.add(orderDayField);

        panel.add(orderMonthLabel);
        panel.add(orderMonthField);

        panel.add(orderYearLabel);
        panel.add(orderYearField);

        panel.add(orderTypeLabel);
        panel.add(orderTypeField);

        panel.add(orderStatusLabel);
        panel.add(orderStatusField);

        return panel;
    }

    private JPanel createProductInputPanel() {
        JPanel panel = new JPanel(new GridLayout(7, 2));

        JLabel productIdLabel = new JLabel("Entrez l'ID du produit:");
        productIdField = new JTextField();

        JLabel productNameLabel = new JLabel("Entrez la désignation du produit:");
        productNameField = new JTextField();

        JLabel productPriceLabel = new JLabel("Entrez le prix unitaire du produit:");
        productPriceField = new JTextField();

        JLabel productStockLabel = new JLabel("Entrez la quantité en stock du produit:");
        productStockField = new JTextField();

        JLabel productQuantityLabel = new JLabel("Entrez la quantité commandée du produit:");
        productQuantityField = new JTextField();

        JLabel productReductionLabel = new JLabel("Entrez la réduction du produit:");
        productReductionField = new JTextField();

        panel.add(productIdLabel);
        panel.add(productIdField);

        panel.add(productNameLabel);
        panel.add(productNameField);

        panel.add(productPriceLabel);
        panel.add(productPriceField);

        panel.add(productStockLabel);
        panel.add(productStockField);

        panel.add(productQuantityLabel);
        panel.add(productQuantityField);

        panel.add(productReductionLabel);
        panel.add(productReductionField);

        return panel;
    }

    private void handleAddClientAndOrderButton() {
        if (validateClientFields() && validateOrderFields() && validateProductFields()) {
            try {
            	
            	int clientId = Integer.parseInt(clientIdField.getText());
                String clientName = clientNameField.getText();
                String clientAddress = clientAddressField.getText();
                int clientTel = Integer.parseInt(clientTelField.getText());

                Client client = new Client(clientId, clientName, clientAddress, clientTel);
                
                int orderId = Integer.parseInt(orderIdField.getText());
                int orderDay = Integer.parseInt(orderDayField.getText());
                int orderMonth = Integer.parseInt(orderMonthField.getText());
                int orderYear = Integer.parseInt(orderYearField.getText());
                LocalDate orderDate = LocalDate.of(orderYear, orderMonth, orderDay);

                String orderType = orderTypeField.getText();
                int orderStatus = Integer.parseInt(orderStatusField.getText());
                
                Commande order = new Commande(orderId, orderDate, orderType, orderStatus, client);
                
                
                int numberOfProducts = Integer.parseInt(productQuantityField.getText());
                LigneCommande[] productArray = new LigneCommande[numberOfProducts];

                for (int i = 0; i < numberOfProducts; i++) {
                    int productId = Integer.parseInt(productIdField.getText());
                    String productName = productNameField.getText();
                    float productPrice = Float.parseFloat(productPriceField.getText());
                    int productStock = Integer.parseInt(productStockField.getText());
                    int productQuantity = Integer.parseInt(productQuantityField.getText());
                    float productReduction = Float.parseFloat(productReductionField.getText());
                    
                    if (productQuantity > productStock) {
                        JOptionPane.showMessageDialog(null, "Stock insuffisant!");
                        return;
                    }

                    Produit product = new Produit(productId, productName, productPrice, productStock);
                    productArray[i] = new LigneCommande(order, product, productQuantity, productReduction);
                }

                outputTextArea.append("BON DE COMMANDE N " + order.getId() + "\n");
                outputTextArea.append("DATE:       " + order.getDate() + "\n");
                outputTextArea.append("CLIENT:     " + order.client.getNom() + "\n");
                outputTextArea.append("LES PRODUITS:   \n");
                outputTextArea.append(" DESIGNATION   Quantité    PRIX UNITAIRE  REDUCTION  TOTAL       \n");

                for (int i = 0; i < numberOfProducts; i++) {
                    outputTextArea.append(" " + productArray[i].produit.getDes() + "           " + productArray[i].getQtecmd() + "      "
                            + productArray[i].produit.getPrix() + "        " + productArray[i].getReduction() + "     "
                            + productArray[i].calculTotalProduit() + "\n");
                }

                outputTextArea.append("TOTAL: " + order.calculTotalCommande(productArray, numberOfProducts) + "\n");
                outputTextArea.append("TOTAL TTC: " + (order.calculTotalCommande(productArray, numberOfProducts)
                        - (order.calculTotalCommande(productArray, numberOfProducts) * 0.2)) + "\n");

                clearInputFields();	
            	
            }catch (DateTimeException e) {
                JOptionPane.showMessageDialog(null, "Date non valide. Veuillez saisir une date correcte.");
            }
        }
    }


    private boolean validateClientFields() {
        return validateField(clientIdField, "Identifiant du client") &&
                validateField(clientNameField, "Nom et prénom du client") &&
                validateField(clientAddressField, "L'adresse du client") &&
                validateField(clientTelField, "Numéro de téléphone du client");
    }

    private boolean validateOrderFields() {
        return validateField(orderIdField, "Numéro de commande") &&
                validateIntegerField(orderDayField, "Jour de la commande", 1, 31) &&
                validateIntegerField(orderMonthField, "Mois de la commande", 1, 12) &&
                validateIntegerField(orderYearField, "Année de la commande", 1, Integer.MAX_VALUE) &&
                validateField(orderTypeField, "Type de commande") &&
                validateIntegerField(orderStatusField, "Statut de paiement", 0, 1);
    }

    private boolean validateProductFields() {
        return validateField(productIdField, "ID du produit") &&
                validateField(productNameField, "Désignation du produit") &&
                validateFloatField(productPriceField, "Prix unitaire du produit") &&
                validateField(productStockField, "Quantité en stock du produit") &&
                validateField(productQuantityField, "Quantité commandée du produit") &&
                validateFloatField(productReductionField, "Réduction du produit");
    }
    
    private boolean validateFloatField(JTextField field, String fieldName) {
        String value = field.getText().trim();
        if (value.isEmpty()) {
            JOptionPane.showMessageDialog(null, fieldName + " ne peut pas être vide");
            return false;
        }

        try {
            Float.parseFloat(value);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Saisissez correctement la valeur de " + fieldName);
            return false;
        }

        return true;
    }

    private boolean validateField(JTextField field, String fieldName) {
        String value = field.getText().trim();
        if (value.isEmpty()) {
            JOptionPane.showMessageDialog(null, fieldName + " ne peut pas être vide");
            return false;
        }

        if (field == orderTypeField) {
            if (!value.equalsIgnoreCase("express") && !value.equalsIgnoreCase("normal")) {
                JOptionPane.showMessageDialog(null, "Saisissez correctement " + fieldName);
                return false;
            }
        } else {
            if (field == clientNameField || field == clientAddressField || field == productNameField) {
                if (!value.matches("[a-zA-Z\\s]+")) {
                    JOptionPane.showMessageDialog(null, "Saisissez correctement " + fieldName);
                    return false;
                }
            } else {
                try {
                    Integer.parseInt(value);
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(null, "Saisissez correctement la valeur de " + fieldName);
                    return false;
                }
            }
        }

        return true;
    }

    private boolean validateIntegerField(JTextField field, String fieldName, int minValue, int maxValue) {
        String value = field.getText().trim();
        if (value.isEmpty()) {
            JOptionPane.showMessageDialog(null, fieldName + " ne peut pas être vide");
            return false;
        }

        try {
            int intValue = Integer.parseInt(value);
            if (intValue < minValue || intValue > maxValue) {
                JOptionPane.showMessageDialog(null, "Saisissez une valeur entre " + minValue + " et " + maxValue + " pour " + fieldName);
                return false;
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Saisissez correctement la valeur de " + fieldName);
            return false;
        }

        return true;
    }

    private void clearInputFields() {
        clientIdField.setText("");
        clientNameField.setText("");
        clientAddressField.setText("");
        clientTelField.setText("");
        orderIdField.setText("");
        orderDayField.setText("");
        orderMonthField.setText("");
        orderYearField.setText("");
        orderTypeField.setText("");
        orderStatusField.setText("");
        productIdField.setText("");
        productNameField.setText("");
        productPriceField.setText("");
        productStockField.setText("");
        productQuantityField.setText("");
        productReductionField.setText("");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new GestionCommandeGUI());
    }
}
