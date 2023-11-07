package GUI;

import javax.swing.*;

import com.formdev.flatlaf.FlatLightLaf;

import java.awt.*;

import Modules.Account;
import Modules.Account.*;

public class MainFrame extends JFrame {
    public Account account;
    JTabbedPane tabbedPane;

    public MainFrame(Account c) {
        super();

        account = c;

        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        setLayout(null);
        setLocationRelativeTo(null);
        setSize(1080, 720);
        setBounds(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2, 1080, 720);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        tabbedPane = new JTabbedPane(JTabbedPane.LEFT);
        // creating icon

        addTab(tabbedPane, NotificationPanel.class, "Notifications", 0);
        addTab(tabbedPane, AccountInfoPanel.class, "Account info", 1);
        switch (account.getAccountType()) {
            case MANAGER:
                addTab(tabbedPane, RoomSearchPanel.class, "Search room", 2);
                addTab(tabbedPane, BookingReviewPanel.class, "Review Booking", 3);
                addTab(tabbedPane, AccountManagementPanel.class, "Manage account", 4);
                
                break;

            case RECEPTIONIST:
                addTab(tabbedPane, RoomSearchPanel.class, "Search room", 2);
                addTab(tabbedPane, BookingReviewPanel.class, "Review Booking", 3);
                break;

            case GUEST:
                addTab(tabbedPane, RoomSearchPanel.class, "Search room", 2);
                break;

            default:
                break;
        }
        
        tabbedPane.setTabLayoutPolicy(JTabbedPane.SCROLL_TAB_LAYOUT);
        tabbedPane.setBounds(0, 0, 1080, 720);
        add(tabbedPane);
    }

    private <T> void addTab(JTabbedPane tabbedPane, Class<T> tabType, String tabName, int index) {
        T t;
        try {
            t = tabType.getDeclaredConstructor(MainFrame.class).newInstance(this);
            tabbedPane.addTab(tabName, null, (JComponent)t, "huh");
            JLabel label = new JLabel(tabName);
            label.setPreferredSize(new Dimension(100, 30));
            tabbedPane.setTabComponentAt(index, label);

        } catch (Exception e) {
            System.out.println("Invalid tab type or tab constructor");
            e.printStackTrace();
        }
    }

    public void onDataBaseChange() {
        for (int i = 0; i < tabbedPane.getTabCount(); i++) {
            ChildrenPanel p = (ChildrenPanel)tabbedPane.getComponentAt(i);
            p.onDataBaseChange();
        }
    }

    public static void main(String[] args) {
        FlatLightLaf.setup();

        MainFrame m = new MainFrame(
            new Account("1", AccountType.MANAGER, "drac_34", "password", "Dracula", Race.VAMPIRE)
        );
        m.setVisible(true);
    }
}