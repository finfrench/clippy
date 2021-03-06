package org.oldbox.clippy.frames;

import com.intellij.uiDesigner.core.GridConstraints;
import com.intellij.uiDesigner.core.GridLayoutManager;
import com.intellij.uiDesigner.core.Spacer;
import org.oldbox.clippy.ClippyContext;

import javax.swing.*;
import java.awt.*;
import java.nio.file.FileSystemException;
import java.security.InvalidParameterException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class AddCategoryFrame extends JFrame {
    private JTextField categoryName;
    private JButton addButton;
    private JPanel panel;
    private JComboBox colorPicker;

    private static final Map<String, Color> colors;

    static {
        Map<String, Color> c = new HashMap<>();
        c.put("red", Color.red);
        c.put("blue", Color.blue);
        c.put("green", Color.green);
        c.put("white", Color.white);
        c.put("cyan", Color.cyan);
        c.put("magenta", Color.magenta);
        c.put("pink", Color.pink);
        c.put("yellow", Color.yellow);
        colors = Collections.unmodifiableMap(c);
    }

    public AddCategoryFrame() {
        super();

        this.setEnabled(true);
        this.setVisible(true);
        this.setSize(200, 120);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        this.addButton.addActionListener(e -> {

            String categoryName = this.categoryName.getText();
            String selectedColor = (String) this.colorPicker.getSelectedItem();

            ClippyContext ctx = ClippyContext.getInstance();

            try {
                ctx.getRepository().addCategory(categoryName, colors.get(selectedColor));
                this.setVisible(false);
                this.dispose();
            } catch (InvalidParameterException exception) {
                JOptionPane.showMessageDialog(this, "Category already exists");
            } catch (FileSystemException e1) {
                e1.printStackTrace();
                JOptionPane.showMessageDialog(null, "Unable to read from save file");
            }

            // a note for now, alternate way of closing window with event
            //this.dispatchEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSING));
        });
        this.setContentPane(panel);
    }

    {
// GUI initializer generated by IntelliJ IDEA GUI Designer
// >>> IMPORTANT!! <<<
// DO NOT EDIT OR ADD ANY CODE HERE!
        $$$setupUI$$$();
    }

    /**
     * Method generated by IntelliJ IDEA GUI Designer
     * >>> IMPORTANT!! <<<
     * DO NOT edit this method OR call it in your code!
     *
     * @noinspection ALL
     */
    private void $$$setupUI$$$() {
        panel = new JPanel();
        panel.setLayout(new GridLayoutManager(5, 1, new Insets(0, 0, 0, 0), -1, -1));
        panel.setBorder(BorderFactory.createTitledBorder(""));
        final JLabel label1 = new JLabel();
        label1.setEnabled(true);
        label1.setText("Add new category");
        panel.add(label1, new GridConstraints(0, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final Spacer spacer1 = new Spacer();
        panel.add(spacer1, new GridConstraints(4, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_VERTICAL, 1, GridConstraints.SIZEPOLICY_WANT_GROW, null, null, null, 0, false));
        categoryName = new JTextField();
        panel.add(categoryName, new GridConstraints(1, 0, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
        addButton = new JButton();
        addButton.setText("Add");
        panel.add(addButton, new GridConstraints(3, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        colorPicker = new JComboBox();
        final DefaultComboBoxModel defaultComboBoxModel1 = new DefaultComboBoxModel();
        defaultComboBoxModel1.addElement("white");
        defaultComboBoxModel1.addElement("red");
        defaultComboBoxModel1.addElement("blue");
        defaultComboBoxModel1.addElement("green");
        defaultComboBoxModel1.addElement("yellow");
        defaultComboBoxModel1.addElement("cyan");
        defaultComboBoxModel1.addElement("magenta");
        defaultComboBoxModel1.addElement("pink");
        colorPicker.setModel(defaultComboBoxModel1);
        panel.add(colorPicker, new GridConstraints(2, 0, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
    }

    /**
     * @noinspection ALL
     */
    public JComponent $$$getRootComponent$$$() {
        return panel;
    }
}
