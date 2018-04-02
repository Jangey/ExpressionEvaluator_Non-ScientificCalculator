
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EvaluatorUI extends JFrame implements ActionListener {

    private TextField txField = new TextField();
    private Panel buttonPanel = new Panel();

    // create new evaluator 
    private Evaluator evaluator = new Evaluator();
    // recall for aeverything in expression
    private String expression = "";
    // 
    private String newInput = "";

    // total of 20 buttons on the calculator,
    // numbered from left to right, top to bottom
    // bText[] array contains the text for corresponding buttons
    private static final String[] bText = {
        "7", "8", "9", "+", "4", "5", "6", "- ", "1", "2", "3",
        "*", "0", "^", "=", "/", "(", ")", "C", "CE"
    };
    private Button[] buttons = new Button[bText.length];

    public static void main(String argv[]) {
        EvaluatorUI calc = new EvaluatorUI();
    }

    public EvaluatorUI() {
        setLayout(new BorderLayout());

        add(txField, BorderLayout.NORTH);
        txField.setEditable(false);

        add(buttonPanel, BorderLayout.CENTER);
        buttonPanel.setLayout(new GridLayout(5, 4));

        //create 20 buttons with corresponding text in bText[] array
        for (int i = 0; i < 20; i++) {
            buttons[i] = new Button(bText[i]);
        }

        //add buttons to button panel
        for (int i = 0; i < 20; i++) {
            buttonPanel.add(buttons[i]);
        }

        //set up buttons to listen for mouse input
        for (int i = 0; i < 20; i++) {
            buttons[i].addActionListener(this);
        }

        setTitle("Calculator");
        setSize(400, 400);
        setLocationByPlatform(true);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent arg0) {
        // You need to fill in this fuction
        //the string of button
        
        // Get input from user
        String newText = arg0.getActionCommand().trim();

        // When user click "C"
        if (arg0.getSource().equals(buttons[18])) {

            // reset everything empty
            txField.setText("");
            this.expression = "";
            this.newInput = "";

        } 
        // When user click "CE"
        else if (arg0.getSource().equals(buttons[19])) {
            // calculate the length of expression
            this.newInput = "";
            int size = this.expression.length();
            int i;
            // count for the length of expression
            for (i = size - 1; i >= 0; i--) {
                if (!Character.isDigit(expression.charAt(i))) {
                    break;
                }
            }
            // remode the expression
            this.expression = this.expression.substring(0, i + 1);
            // continues to show the rest of expression
            this.txField.setText(expression);

        } 
        // When user click "Number" or "operator"
        else if (!arg0.getSource().equals(buttons[14])
                && !arg0.getSource().equals(buttons[18])
                && !arg0.getSource().equals(buttons[19])) {
            // current = current + new insert
            this.newInput += newText;
            // expression = expression + new insert
            this.expression += newText;
            // show user the current expression
            this.txField.setText(expression);
        } 
        // When user click "equal sign"
        else if (arg0.getSource().equals(buttons[14])) {
            // store the result
            int result = this.evaluator.eval(this.expression);
            //replace resulet with string and show to user
            this.txField.setText(String.valueOf(result));
            //clear the window
            this.expression = "";
            this.newInput = "";
        }

    }
}
