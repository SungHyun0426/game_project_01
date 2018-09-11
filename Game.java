//SungHyun Yoon

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.Timer;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class Game
{
  //Holds every classes
  JFrame frame;
  JPanel cards;
  Panel_Menu menu;
  Panel_Tutorial tutorial;
  Panel_Battle battle;

  CardLayout cardLayout = new CardLayout();

  Image gui_menu = new ImageIcon("GUI_Menu.png").getImage();
  Image gui_menu_overlay_00 = new ImageIcon("GUI_Menu_Overlay_00.png").getImage();
  Image gui_menu_overlay_01 = new ImageIcon("GUI_Menu_Overlay_01.png").getImage();
  Image gui_menu_overlay_02 = new ImageIcon("GUI_Menu_Overlay_02.png").getImage();
  Image gui_menu_overlay_03 = new ImageIcon("GUI_Menu_Overlay_03.png").getImage();

  Image gui_tutorial_00 = new ImageIcon("GUI_Tutorial_00.png").getImage();
  Image gui_tutorial_01 = new ImageIcon("GUI_Tutorial_01.png").getImage();
  Image gui_tutorial_02 = new ImageIcon("GUI_Tutorial_02.png").getImage();
  Image gui_tutorial_03 = new ImageIcon("GUI_Tutorial_03.png").getImage();
  Image gui_tutorial_04 = new ImageIcon("GUI_Tutorial_04.png").getImage();
  Image gui_tutorial_05 = new ImageIcon("GUI_Tutorial_05.png").getImage();
  Image gui_tutorial_overlay_00 = new ImageIcon("GUI_Tutorial_Overlay_00.png").getImage();
  Image gui_tutorial_overlay_01 = new ImageIcon("GUI_Tutorial_Overlay_01.png").getImage();
  Image gui_tutorial_overlay_02 = new ImageIcon("GUI_Tutorial_Overlay_02.png").getImage();

  Image gui_battle = new ImageIcon("GUI_Battle.png").getImage();
  Image surrender = new ImageIcon("Surrender.png").getImage();
  Image background_camp = new ImageIcon("Background_Camp.png").getImage();
  Image background_woods = new ImageIcon("Background_Woods.png").getImage();
  Image map = new ImageIcon("Map.png").getImage();

  Image witcher_01_01 = new ImageIcon("Witcher_01_01.png").getImage();
  Image witcher_01_02 = new ImageIcon("Witcher_01_02.png").getImage();
  Image witcher_02_01 = new ImageIcon("Witcher_02_01.png").getImage();
  Image witcher_02_02 = new ImageIcon("Witcher_02_02.png").getImage();
  Image witcher_03_01 = new ImageIcon("Witcher_03_01.png").getImage();
  Image witcher_03_02 = new ImageIcon("Witcher_03_02.png").getImage();

  Image witcher_select = new ImageIcon("witcher_Select.png").getImage();

  Image monster_hybrid_griffin_01 = new ImageIcon("Monster_Hybrid_Griffin_01.png").getImage();
  Image monster_necrophage_alghoul_01 = new ImageIcon("Monster_Necrophage_Alghoul_01.png").getImage();
  Image monster_necrophage_drowner_01 = new ImageIcon("Monster_Necrophage_Drowner_01.png").getImage();
  Image monster_necrophage_ghoul_01 = new ImageIcon("Monster_Necrophage_Ghoul_01.png").getImage();
  Image monster_necrophage_water_hag_01 = new ImageIcon("Monster_Necrophage_Water_Hag_01.png").getImage();
  Image monster_relict_leshe_01 = new ImageIcon("Monster_Relict_Leshe_01.png").getImage();
  Image monster_specter_wraith_01 = new ImageIcon("Monster_Specter_Wraith_01.png").getImage();

  Image monster_select = new ImageIcon("Monster_Select.png").getImage();

  Image empty_01 = new ImageIcon("Empty_01.png").getImage();
  Image empty_02 = new ImageIcon("Empty_02.png").getImage();
  Image empty_03 = new ImageIcon("Empty_03.png").getImage();

  Image potion_white_raffards_decotion = new ImageIcon("Potion_White_Raffard's_Decotion.png").getImage();
  Image potion_white_honey = new ImageIcon("Potion_White_Honey.png").getImage();

  Image sign_01_aard = new ImageIcon("Sign_01_Aard.png").getImage();
  Image sign_02_igni = new ImageIcon("Sign_02_Igni.png").getImage();
  Image sign_03_yrden = new ImageIcon("Sign_03_Yrden.png").getImage();
  Image sign_04_quen = new ImageIcon("Sign_04_Quen.png").getImage();
  Image sign_05_axii = new ImageIcon("Sign_05_Axii.png").getImage();

  Image gws_silver = new ImageIcon("Grandmaster_Wolven_Sword_Silver.png").getImage();
  Image gws_steel = new ImageIcon("Grandmaster_Wolven_Sword_Steel.png").getImage();

  Image slot_locked_01 = new ImageIcon("Slot_Locked_01.png").getImage();
  Image slot_locked_02 = new ImageIcon("Slot_Locked_02.png").getImage();
  Image slot_border_01_01 = new ImageIcon("Slot_Border_01_01.png").getImage();
  Image slot_border_01_02 = new ImageIcon("Slot_Border_01_02.png").getImage();
  Image slot_border_02 = new ImageIcon("Slot_Border_02.png").getImage();
  Image slot_expand_potion = new ImageIcon("Slot_Expand_Potion.png").getImage();
  Image slot_expand_sign = new ImageIcon("Slot_Expand_Sign.png").getImage();

  Image hover = new ImageIcon("Hover.png").getImage();
  Image shadow = new ImageIcon("Shadow.png").getImage();

  Image monster_healthBar = new ImageIcon("Monster_HealthBar.png").getImage();

  public Game()
  {
    //Initializes panels
    cards = new JPanel(cardLayout);
    menu = new Panel_Menu();
    tutorial = new Panel_Tutorial();
    battle = new Panel_Battle();

    //Adds panels to CardLayout
    cards.add(menu, "panel_menu");
    cards.add(tutorial, "panel_tutorial");
    cards.add(battle, "panel_battle");

    cardLayout.show(cards, "panel_menu");
  }
  public static void main(String[] args)
  {
    Game playGame = new Game();
    playGame.runIt();
  }
  public void runIt()
  {
    //Puts the frame together
    frame = new JFrame("Game_SungHyun");
    frame.setLocation(0, 0);
    frame.setSize(1200, 622);
    frame.setResizable(false);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setContentPane(cards);
    frame.setVisible(true);
  }
  class Panel_Menu extends JPanel implements KeyListener, MouseListener, MouseMotionListener
  {
    //Contains start, continue, tutorial, and quit button
    int button_location;

    public Panel_Menu()
    {
      //Adds listeners
      addKeyListener(this);
      addMouseListener(this);
      addMouseMotionListener(this);

      button_location = -1;
    }
    public void paintComponent(Graphics g)
    {
      //Draws gui using images
      super.paintComponent(g);

      g.drawImage(gui_menu, 0, 0, 1200, 600, null);

      //If cursor is hovering over a button, the button is highlighted
      if(button_location == 0)
      {
        g.drawImage(gui_menu_overlay_00, 0, 0, 1200, 600, null);
      }
      else if(button_location == 1)
      {
        g.drawImage(gui_menu_overlay_01, 0, 0, 1200, 600, null);
      }
      else if(button_location == 2)
      {
        g.drawImage(gui_menu_overlay_02, 0, 0, 1200, 600, null);
      }
      else if(button_location == 3)
      {
        g.drawImage(gui_menu_overlay_03, 0, 0, 1200, 600, null);
      }
    }
    public void menuSound(int i)
    {
      //Plays sound
      try
      {
        AudioInputStream menu_open = AudioSystem.getAudioInputStream(this.getClass().getResource("menu_open.wav"));
        AudioInputStream menu_close = AudioSystem.getAudioInputStream(this.getClass().getResource("menu_close.wav"));
        Clip clip = AudioSystem.getClip();

        if(i == 0)
        {
          clip.open(menu_open);
        }
        else if(i == 1)
        {
          clip.open(menu_close);
        }

        clip.start();
      }
      catch(Exception e)
      {
        e.printStackTrace();
      }
    }
    public void keyTyped(KeyEvent e){}
    public void keyPressed(KeyEvent e)
    {
      //Uses arrow keys to select button
      if(e.getKeyCode() == KeyEvent.VK_UP)
      {
        if(button_location == -1 || button_location == 0)
        {
          button_location = 3;
        }
        else
        {
          button_location--;
        }
      }
      else if(e.getKeyCode() == KeyEvent.VK_DOWN)
      {
        if(button_location == 3)
        {
          button_location = 0;
        }
        else
        {
          button_location++;
        }
      }
      else if(e.getKeyCode() == KeyEvent.VK_ENTER)
      {
        if(button_location == 0)
        {
          cardLayout.show(cards, "panel_battle");
        }
        else if(button_location == 2)
        {
          menuSound(0);
          cardLayout.show(cards, "panel_tutorial");
        }
        else if(button_location == 3)
        {
          menuSound(1);

          System.exit(0);
        }
      }
      repaint();
    }
    public void keyReleased(KeyEvent e){}
    public void mouseClicked(MouseEvent e){}
    public void mousePressed(MouseEvent e)
    {
      //Uses mouse to select button
      requestFocus();

      if(e.getX() >= 192 && e.getX() <= 378 && e.getY() >= 144 && e.getY() <= 198)
      {
        cardLayout.show(cards, "panel_battle");
      }
      else if(e.getX() >= 192 && e.getX() <= 486 && e.getY() >= 312 && e.getY() <= 366)
      {
        menuSound(0);
        cardLayout.show(cards, "panel_tutorial");
      }
      else if(e.getX() >= 192 && e.getX() <= 342 && e.getY() >= 396 && e.getY() <= 450)
      {
        menuSound(1);
        System.exit(0);
      }
      else
      {
        button_location = -1;
      }
      repaint();
    }
    public void mouseReleased(MouseEvent e){}
    public void mouseEntered(MouseEvent e){}
    public void mouseExited(MouseEvent e){}
    public void mouseMoved(MouseEvent e)
    {
      //Tracks cursor hovering over button
      if(e.getX() >= 192 && e.getX() <= 378 && e.getY() >= 144 && e.getY() <= 198)
      {
        button_location = 0;
      }
      else if(e.getX() >= 192 && e.getX() <= 486 && e.getY() >= 228 && e.getY() <= 282)
      {
        button_location = 1;
      }
      else if(e.getX() >= 192 && e.getX() <= 486 && e.getY() >= 312 && e.getY() <= 366)
      {
        button_location = 2;
      }
      else if(e.getX() >= 192 && e.getX() <= 342 && e.getY() >= 396 && e.getY() <= 450)
      {
        button_location = 3;
      }
      repaint();
    }
    public void mouseDragged(MouseEvent e){}
  }
  class Panel_Tutorial extends JPanel implements KeyListener, MouseListener, MouseMotionListener
  {
    //Shows tutorial
    int tutorial_location;

    boolean button_hover_00;
    boolean button_hover_01;
    boolean button_hover_02;

    public Panel_Tutorial()
    {
      addKeyListener(this);
      addMouseListener(this);
      addMouseMotionListener(this);

      tutorial_location = 0;

      button_hover_00 = false;
      button_hover_01 = false;
      button_hover_02 = false;
    }
    public void paintComponent(Graphics g)
    {
      //Draws gui using images
      super.paintComponent(g);

      if(tutorial_location == 0)
      {
        g.drawImage(gui_tutorial_00, 0, 0, 1200, 600, null);
      }
      else if(tutorial_location == 1)
      {
        g.drawImage(gui_tutorial_01, 0, 0, 1200, 600, null);
        g.drawImage(sign_01_aard, 1026, 156, 30, 30, null);
      }
      else if(tutorial_location == 2)
      {
        g.drawImage(gui_tutorial_02, 0, 0, 1200, 600, null);
        g.drawImage(sign_02_igni, 1026, 156, 30, 30, null);
      }
      else if(tutorial_location == 3)
      {
        g.drawImage(gui_tutorial_03, 0, 0, 1200, 600, null);
        g.drawImage(sign_03_yrden, 1026, 156, 30, 30, null);
      }
      else if(tutorial_location == 4)
      {
        g.drawImage(gui_tutorial_04, 0, 0, 1200, 600, null);
        g.drawImage(sign_04_quen, 1026, 156, 30, 30, null);
      }
      else if(tutorial_location == 5)
      {
        g.drawImage(gui_tutorial_05, 0, 0, 1200, 600, null);
        g.drawImage(sign_05_axii, 1026, 156, 30, 30, null);
      }

      if(button_hover_00)
      {
        g.drawImage(gui_tutorial_overlay_00, 0, 0, 1200, 600, null);
      }
      else if(button_hover_01)
      {
        g.drawImage(gui_tutorial_overlay_01, 0, 0, 1200, 600, null);
      }
      else if(button_hover_02)
      {
        g.drawImage(gui_tutorial_overlay_02, 0, 0, 1200, 600, null);
      }
    }
    public void tutorialSound(int i)
    {
      //Plays sound
      try
      {
        AudioInputStream menu_open = AudioSystem.getAudioInputStream(this.getClass().getResource("menu_open.wav"));
        AudioInputStream menu_close = AudioSystem.getAudioInputStream(this.getClass().getResource("menu_close.wav"));
        AudioInputStream page_change = AudioSystem.getAudioInputStream(this.getClass().getResource("page_change.wav"));
        Clip clip = AudioSystem.getClip();

        if(i == 0)
        {
          clip.open(menu_open);
        }
        else if(i == 1)
        {
          clip.open(menu_close);
        }
        else if(i == 2)
        {
          clip.open(page_change);
        }

        clip.start();
      }
      catch(Exception e)
      {
        e.printStackTrace();
      }
    }
    public void keyTyped(KeyEvent e){}
    public void keyPressed(KeyEvent e)
    {
      //Uses arrow keys to select button
      if(e.getKeyCode() == KeyEvent.VK_LEFT)
      {
        if(tutorial_location == 0)
        {
          tutorial_location = 0;
          tutorialSound(0);
        }
        else
        {
          tutorial_location--;
          tutorialSound(2);
        }

        button_hover_00 = false;
        button_hover_01 = true;
        button_hover_02 = false;
      }
      else if(e.getKeyCode() == KeyEvent.VK_RIGHT)
      {
        if(tutorial_location == 5)
        {
          tutorial_location = 5;
          tutorialSound(0);
        }
        else
        {
          tutorial_location++;
          tutorialSound(2);
        }

        button_hover_00 = false;
        button_hover_01 = false;
        button_hover_02 = true;
      }
      else if(e.getKeyCode() == KeyEvent.VK_ESCAPE)
      {
        button_hover_00 = true;
        button_hover_01 = false;
        button_hover_02 = false;

        tutorial_location = 0;

        tutorialSound(1);
        cardLayout.show(cards, "panel_menu");
      }

      repaint();
    }
    public void keyReleased(KeyEvent e){}
    public void mouseClicked(MouseEvent e){}
    public void mousePressed(MouseEvent e)
    {
      //Uses mouse to select button
      requestFocus();

      if(e.getX() >= 192 && e.getX() <= 288 && e.getY() >= 60 && e.getY() <= 114)
      {
        tutorial_location = 0;

        tutorialSound(1);

        cardLayout.show(cards, "panel_menu");
      }
      else if(e.getX() >= 192 && e.getX() <= 288 && e.getY() >= 444 && e.getY() <= 498)
      {
        if(tutorial_location == 0)
        {
          tutorial_location = 0;
          tutorialSound(0);
        }
        else
        {
          tutorial_location--;
          tutorialSound(2);
        }
      }
      else if(e.getX() >= 966 && e.getX() <= 1062 && e.getY() >= 444 && e.getY() <= 498)
      {
        if(tutorial_location == 5)
        {
          tutorial_location = 5;
          tutorialSound(0);
        }
        else
        {
          tutorial_location++;
          tutorialSound(2);
        }
      }
      repaint();
    }
    public void mouseReleased(MouseEvent e){}
    public void mouseEntered(MouseEvent e){}
    public void mouseExited(MouseEvent e){}
    public void mouseMoved(MouseEvent e)
    {
      //Tracks cursor hovering over button
      if(e.getX() >= 192 && e.getX() <= 288 && e.getY() >= 60 && e.getY() <= 114)
      {
        button_hover_00 = true;
        button_hover_01 = false;
        button_hover_02 = false;
      }
      else if(e.getX() >= 192 && e.getX() <= 288 && e.getY() >= 444 && e.getY() <= 498)
      {
        button_hover_00 = false;
        button_hover_01 = true;
        button_hover_02 = false;
      }
      else if(e.getX() >= 966 && e.getX() <= 1062 && e.getY() >= 444 && e.getY() <= 498)
      {
        button_hover_00 = false;
        button_hover_01 = false;
        button_hover_02 = true;
      }
      repaint();
    }
    public void mouseDragged(MouseEvent e){}
  }
  class Panel_Battle extends JPanel implements KeyListener, MouseListener, MouseMotionListener, ActionListener
  {
    //Actual gameplay
    String location_01;
    String location_02;

    String monster_01;
    String monster_02;
    String monster_03;

    int tick;
    int x_point;
    int y_point;
    int background;

    int battleChance;
    int random_num_2;
    int random_num_3;

    int witcher_action_01;
    int witcher_action_02;
    int witcher_action_03;

    int monster_action;

    int witcher_health;
    int witcher_health_01;
    int witcher_health_02;
    int witcher_health_03;
    int witcher_toxicity;
    int witcher_toxicity_01;
    int witcher_toxicity_02;
    int witcher_toxicity_03;

    int monster_health;
    int monster_health_01;
    int monster_health_02;
    int monster_health_03;

    boolean witcher_02_locked;
    boolean witcher_03_locked;

    boolean witcher_select_01;
    boolean witcher_select_02;
    boolean witcher_select_03;

    boolean witcher_hover_01;
    boolean witcher_hover_02;
    boolean witcher_hover_03;

    boolean slot_select_weapon_1;
    boolean slot_select_weapon_2;
    boolean slot_select_weapon_3;
    boolean slot_select_weapon_4;

    boolean slot_hover_weapon_1;
    boolean slot_hover_weapon_2;
    boolean slot_hover_weapon_3;
    boolean slot_hover_weapon_4;

    boolean slot_select_weapon_3_locked;
    boolean slot_select_weapon_4_locked;

    boolean slot_select_potion_0;
    boolean slot_select_potion_1;
    boolean slot_select_potion_2;

    boolean slot_select_sign_0;
    boolean slot_select_sign_1;
    boolean slot_select_sign_2;
    boolean slot_select_sign_3;
    boolean slot_select_sign_4;
    boolean slot_select_sign_5;

    boolean slot_select_map;

    boolean disable_battleChance_01;
    boolean disable_battleChance_02;
    boolean disable_moving_background;
    boolean moveFoward;

    boolean location_camp;
    boolean location_road;

    boolean mouseEnabled;

    Timer timer = new Timer(1000, this);

    public Panel_Battle()
    {
      addKeyListener(this);
      addMouseListener(this);
      addMouseMotionListener(this);

      location_01 = "0,0";
      location_02 = "";

      monster_01 = "";
      monster_02 = "";
      monster_03 = "";

      tick = 0;
      background = 0;

      monster_action = 0;

      witcher_health = 50;
      witcher_health_01 = 0;
      witcher_health_02 = 0;
      witcher_health_03 = 0;
      witcher_toxicity = 50;
      witcher_toxicity_01 = 50;
      witcher_toxicity_02 = 50;
      witcher_toxicity_03 = 50;

      monster_health = witcher_health*2/5;
      monster_health_01 = 0;
      monster_health_02 = 0;
      monster_health_03 = 0;

      witcher_02_locked = true;
      witcher_03_locked = true;

      witcher_action_01 = 2;

      if(witcher_02_locked)
      {
        witcher_action_02 = 0;
      }
      else
      {
        witcher_action_02 = 2;
      }
      if(witcher_03_locked)
      {
        witcher_action_03 = 0;
      }
      else
      {
        witcher_action_03 = 2;
      }

      witcher_select_01 = false;
      witcher_select_02 = false;
      witcher_select_03 = false;

      witcher_hover_01 = false;
      witcher_hover_02 = false;
      witcher_hover_03 = false;

      slot_select_weapon_1 = false;
      slot_select_weapon_2 = false;
      slot_select_weapon_3 = false;
      slot_select_weapon_4 = false;

      slot_hover_weapon_1 = false;
      slot_hover_weapon_2 = false;
      slot_hover_weapon_3 = false;
      slot_hover_weapon_4 = false;

      slot_select_weapon_3_locked = true;
      slot_select_weapon_4_locked = true;

      slot_select_potion_0 = false;
      slot_select_potion_1 = false;
      slot_select_potion_2 = false;

      slot_select_sign_0 = false;
      slot_select_sign_1 = false;
      slot_select_sign_2 = false;
      slot_select_sign_3 = false;
      slot_select_sign_4 = false;
      slot_select_sign_5 = false;

      slot_select_map = false;

      disable_battleChance_01 = false;
      disable_battleChance_02 = false;
      disable_moving_background = false;
      moveFoward = true;

      location_camp = true;
      location_road = false;

      mouseEnabled = true;
    }
    public void paintComponent(Graphics g)
    {
      //Draws gui using images
      super.paintComponent(g);

      System.out.println("WA1: " + witcher_action_01);
      System.out.println("WA2: " + witcher_action_02);
      System.out.println("WA3: " + witcher_action_03);
      System.out.println("MA: " + monster_action + "\n");

      if(location_camp)
      {
        locationCamp(g);
      }
      if(location_road)
      {
        locationRoad(g);
      }

      witcher(g);
      monster(g);

      g.drawImage(gui_battle, 0, 0, 1200, 600, null);
      g.drawImage(surrender, 0, 0, 1200, 600, null);

      potionSlot(g);
      signSlot(g);
      mapSlot(g);
      weaponSlot(g);
      startBattle();

      g.drawImage(gws_steel, 30, 450, 60, 120, null);
      g.drawImage(gws_silver, 120, 450, 60, 120, null);

      if(slot_select_weapon_3_locked)
      {
        g.drawImage(slot_locked_01, 210, 450, 60, 120, null);
      }
      if(slot_select_weapon_4_locked)
      {
        g.drawImage(slot_locked_01, 300, 450, 60, 120, null);
      }
    }
    public void locationCamp(Graphics g)
    {
      g.drawImage(background_camp, 0, 0, 1200, 600, null);
    }
    public void locationRoad(Graphics g)
    {
      g.drawImage(background_woods, 0 - background, 0, 1800, 600, null);
      g.drawImage(background_woods, 1800 - background, 0, 1800, 600, null);
    }
    public void witcher(Graphics g)
    {
      Font font_24 = new Font("Arial", Font.PLAIN, 18);

      if(witcher_hover_01 || witcher_select_01)
      {
        g.setFont(font_24);
        g.setColor(new Color(120, 120, 120));
        g.drawString("Geralt of Rivia", 36, 384);

        g.setColor(new Color(120, 20, 15));
        g.drawString("" + (witcher_health - witcher_health_01) + "/" + witcher_health, 288, 384);

        g.setColor(new Color(30, 95, 0));
        g.drawString("" + (witcher_toxicity - witcher_toxicity_01) + "/" + witcher_toxicity, 288, 408);
      }
      else if((witcher_hover_02 && !witcher_02_locked) || witcher_select_02)
      {
        g.setFont(font_24);
        g.setColor(new Color(120, 120, 120));
        g.drawString("Vesemir of Kaer Morhen", 36, 384);

        g.setColor(new Color(120, 20, 15));
        g.drawString("" + (witcher_health - witcher_health_02) + "/" + witcher_health, 288, 384);

        g.setColor(new Color(30, 95, 0));
        g.drawString("" + (witcher_toxicity - witcher_toxicity_02) + "/" + witcher_toxicity, 288, 408);
      }
      else if((witcher_hover_03 && !witcher_03_locked) || witcher_select_03)
      {
        g.setFont(font_24);
        g.setColor(new Color(120, 120, 120));
        g.drawString("Eskel", 36, 384);

        g.setColor(new Color(120, 20, 15));
        g.drawString("" + (witcher_health - witcher_health_03) + "/" + witcher_health, 288, 384);

        g.setColor(new Color(30, 95, 0));
        g.drawString("" + (witcher_toxicity - witcher_toxicity_03) + "/" + witcher_toxicity, 288, 408);
      }

      if(!disable_moving_background)
      {
        if(moveFoward)
        {
          g.drawImage(witcher_01_01, 423, 114, 105, 210, null);

          if(!witcher_02_locked)
          {
            g.drawImage(witcher_02_01, 246, 114, 105, 210, null);
          }

          if(!witcher_03_locked)
          {
            g.drawImage(witcher_03_01, 69, 114, 105, 210, null);
          }
        }
        else
        {
          g.drawImage(witcher_01_01, 423 + 105, 114, -105, 210, null);

          if(!witcher_02_locked)
          {
            g.drawImage(witcher_02_01, 246 + 105, 114, -105, 210, null);
          }

          if(!witcher_03_locked)
          {
            g.drawImage(witcher_03_01, 69 + 105, 114, -105, 210, null);
          }
        }
      }
      else if(disable_moving_background)
      {
        g.drawImage(witcher_01_02, 423, 114, 105, 210, null);

        if(!witcher_02_locked)
        {
          g.drawImage(witcher_02_02, 246, 114, 105, 210, null);
        }
        if(!witcher_03_locked)
        {
          g.drawImage(witcher_03_02, 69, 114, 105, 210, null);
        }

        g.setColor(new Color(20, 20, 20));
        //Health
        g.fillRect(426 + 99 - 99*witcher_health_01/witcher_health, 117, 99*witcher_health_01/witcher_health, 6);
        if(!witcher_02_locked)
        {
          g.fillRect(249 + 99 - 99*witcher_health_02/witcher_health, 117, 99*witcher_health_02/witcher_health, 6);
        }
        if(!witcher_03_locked)
        {
          g.fillRect(72 + 99 - 99*witcher_health_03/witcher_health, 117, 99*witcher_health_03/witcher_health, 6);
        }
        //Toxicity
        g.fillRect(426 + 99 - 99*witcher_toxicity_01/witcher_toxicity, 123, 99*witcher_toxicity_01/witcher_toxicity, 6);
        if(!witcher_02_locked)
        {
          g.fillRect(249 + 99 - 99*witcher_toxicity_02/witcher_toxicity, 123, 99*witcher_toxicity_02/witcher_toxicity, 6);
        }
        if(!witcher_03_locked)
        {
          g.fillRect(72 + 99 - 99*witcher_toxicity_03/witcher_toxicity, 123, 99*witcher_toxicity_03/witcher_toxicity, 6);
        }

        if(witcher_select_01)
        {
          g.drawImage(witcher_select, 423, 114, 105, 210, null);
        }
        else if(witcher_select_02)
        {
          g.drawImage(witcher_select, 246, 114, 105, 210, null);
        }
        else if(witcher_select_03)
        {
          g.drawImage(witcher_select, 69, 114, 105, 210, null);
        }
      }
    }
    public void monster(Graphics g)
    {
      //g.drawImage(monster_hybrid_griffin_01, 669, 0, 384, 340, null);
      //g.drawImage(monster_necrophage_alghoul_01, 669, 36, 327, 363, null);
      //g.drawImage(monster_necrophage_drowner_01, 669, 36, 327, 363, null);
      //g.drawImage(monster_necrophage_ghoul_01, 669, 36, 327, 363, null);
      //g.drawImage(monster_necrophage_water_hag_01, 669, 36, 327, 363, null);
      //g.drawImage(monster_relict_leshe_01, 669, 36, 327, 363, null);
      //g.drawImage(monster_specter_wraith_01, 669, 36, 327, 363, null);

      if(disable_moving_background)
      {
        g.drawImage(monster_healthBar, 669, 114, 105, 210, null);
        g.drawImage(monster_healthBar, 846, 114, 105, 210, null);
        g.drawImage(monster_healthBar, 1023, 114, 105, 210, null);

        g.drawImage(monster_necrophage_drowner_01, 579, 36, 327, 363, null);
        g.drawImage(monster_necrophage_drowner_01, 756, 36, 327, 363, null);
        g.drawImage(monster_necrophage_drowner_01, 933, 36, 327, 363, null);

        g.setColor(new Color(20, 20, 20));
        g.fillRect(672 + 99 - 99*monster_health_01/monster_health, 117, 99*monster_health_01/monster_health, 12);
        g.fillRect(849 + 99 - 99*monster_health_02/monster_health, 117, 99*monster_health_02/monster_health, 12);
        g.fillRect(1026 + 99 - 99*monster_health_03/monster_health, 117, 99*monster_health_03/monster_health, 12);

        if(monster_action != 0)
        {
          mouseEnabled = false;
          timer.start();

          random_num_3 = (int)(Math.random()*3 + 0);
          System.out.println(random_num_3 + "\n");

          if(random_num_3 == 0 && monster_health_01 != monster_health)
          {
            g.drawImage(monster_select, 669, 114, 105, 210, null);
          }
          else if(random_num_3 == 1 && monster_health_01 != monster_health)
          {
            g.drawImage(monster_select, 846, 114, 105, 210, null);
          }
          else if(random_num_3 == 2 && monster_health_01 != monster_health)
          {
            g.drawImage(monster_select, 1023, 114, 105, 210, null);
          }

          random_num_3 = (int)(Math.random()*3 + 0);

          if(random_num_3 == 0 && witcher_health_01 != witcher_health)
          {
            witcher_health_01 = witcher_health_01 + 5 + (int)(Math.random()*3 - 1);
          }
          else if(random_num_3 == 1 && !witcher_02_locked && witcher_health_02 != witcher_health)
          {
            witcher_health_02 = witcher_health_02 + 5 + (int)(Math.random()*3 - 1);
          }
          else if(random_num_3 == 2 && !witcher_03_locked && witcher_health_03 != witcher_health)
          {
            witcher_health_03 = witcher_health_03 + 5 + (int)(Math.random()*3 - 1);
          }

          monster_action -= 1;
        }
        else if(monster_action == 0)
        {
          mouseEnabled = true;
          timer.stop();
          tick = 0;
        }
      }
    }
    public void potionSlot(Graphics g)
    {
      g.drawImage(potion_white_raffards_decotion, 486, 366, 48, 48, null);

      if(slot_select_potion_0)
      {
        g.drawImage(shadow, 0, 0, 1200, 600, null);
        g.drawImage(slot_expand_potion, 474, 354, 168, 72, null);
        g.drawImage(potion_white_raffards_decotion, 486, 366, 48, 48, null);
        g.drawImage(potion_white_honey, 576, 366, 48, 48, null);
      }

      if(slot_select_potion_1 || slot_select_potion_2)
      {
        g.drawImage(slot_border_02, 474, 354, 78, 72, null);

        if(slot_select_potion_1)
        {
          g.drawImage(potion_white_raffards_decotion, 486, 366, 48, 48, null);
        }
        else if(slot_select_potion_2)
        {
          g.drawImage(potion_white_honey, 486, 366, 48, 48, null);
        }
      }
    }
    public void signSlot(Graphics g)
    {
      //Checks if a sign is selected and paints gui using images
      if(slot_select_sign_0)
      {
        g.drawImage(shadow, 0, 0, 1200, 600, null);
        g.drawImage(slot_expand_sign, 384, 444, 438, 72, null);

        g.drawImage(sign_01_aard, 399, 459, 42, 42, null);
        g.drawImage(sign_02_igni, 489, 459, 42, 42, null);
        g.drawImage(sign_03_yrden, 579, 459, 42, 42, null);
        g.drawImage(sign_04_quen, 669, 459, 42, 42, null);
        g.drawImage(sign_05_axii, 759, 459, 42, 42, null);
      }
      else if(!slot_select_sign_1 && !slot_select_sign_2 && !slot_select_sign_3 && !slot_select_sign_4 && !slot_select_sign_5)
      {
        g.drawImage(sign_01_aard, 399, 459, 42, 42, null);
      }

      if(slot_select_sign_1 || slot_select_sign_2 || slot_select_sign_3 || slot_select_sign_4 || slot_select_sign_5)
      {
        g.drawImage(slot_border_02, 384, 444, 78, 72, null);

        if(slot_select_sign_1)
        {
          g.drawImage(sign_01_aard, 399, 459, 42, 42, null);
        }
        else if(slot_select_sign_2)
        {
          g.drawImage(sign_02_igni, 399, 459, 42, 42, null);
        }
        else if(slot_select_sign_3)
        {
          g.drawImage(sign_03_yrden, 399, 459, 42, 42, null);
        }
        else if(slot_select_sign_4)
        {
          g.drawImage(sign_04_quen, 399, 459, 42, 42, null);
        }
        else if(slot_select_sign_5)
        {
          g.drawImage(sign_05_axii, 399, 459, 42, 42, null);
        }
      }
    }
    public void weaponSlot(Graphics g)
    {
      //Checks if a weapon is selected and draws gui using images
      //Weapon Slot - Select
      if(!slot_select_sign_0)
      {
        if(slot_select_weapon_1)
        {
          g.drawImage(slot_border_01_02, 24, 444, 78, 132, null);
        }
        else if(slot_select_weapon_2)
        {
          g.drawImage(slot_border_01_02, 114, 444, 78, 132, null);
        }

        if(!slot_select_weapon_3_locked)
        {
          if(slot_select_weapon_3)
          {
            g.drawImage(slot_border_01_02, 204, 444, 78, 132, null);
          }
        }

        if(!slot_select_weapon_4_locked)
        {
          if(slot_select_weapon_4)
          {
            g.drawImage(slot_border_01_02, 294, 444, 78, 132, null);
          }
        }
      }

      //Weapon Slot - Hover
      if(!slot_select_sign_0 && !slot_select_map)
      {
        if(slot_hover_weapon_1 || slot_hover_weapon_2 || slot_hover_weapon_3 || slot_hover_weapon_4)
        {
          g.drawImage(shadow, 0, 0, 1200, 600, null);

          if(slot_hover_weapon_1)
          {
            if(slot_select_weapon_1)
            {
              g.drawImage(slot_border_01_02, 24, 444, 78, 132, null);
            }
            else
            {
              g.drawImage(slot_border_01_01, 24, 444, 78, 132, null);
            }
          }
          else if(slot_hover_weapon_2)
          {
            if(slot_select_weapon_2)
            {
              g.drawImage(slot_border_01_02, 114, 444, 78, 132, null);
            }
            else
            {
              g.drawImage(slot_border_01_01, 114, 444, 78, 132, null);
            }
          }
          else if(slot_hover_weapon_3)
          {
            if(slot_select_weapon_3)
            {
              g.drawImage(slot_border_01_02, 204, 444, 78, 132, null);
            }
            else
            {
              g.drawImage(slot_border_01_01, 204, 444, 78, 132, null);
            }

            if(slot_select_weapon_3_locked)
            {
              if(y_point <= 534)
              {
                g.drawImage(slot_locked_02, x_point, y_point, 246, 66, null);
              }
              else if(y_point > 534)
              {
                g.drawImage(slot_locked_02, x_point, 534, 246, 66, null);
              }
            }
          }
          else if(slot_hover_weapon_4)
          {
            if(slot_select_weapon_4)
            {
              g.drawImage(slot_border_01_02, 294, 444, 78, 132, null);
            }
            else
            {
              g.drawImage(slot_border_01_01, 294, 444, 78, 132, null);
            }

            if(slot_select_weapon_4_locked)
            {
              if(y_point <= 534)
              {
                g.drawImage(slot_locked_02, x_point, y_point, 246, 66, null);
              }
              else if(y_point > 534)
              {
                g.drawImage(slot_locked_02, x_point, 534, 246, 66, null);
              }
            }
          }
        }
      }
    }
    public void mapSlot(Graphics g)
    {
      if(slot_select_map)
      {
        g.drawImage(shadow, 0, 0, 1200, 600, null);
        g.drawImage(map, 0, 0, 1200, 600, null);

        g.setColor(new Color(150, 60, 60));

        if(Integer.parseInt(location_01.substring(0, 1)) == 0)
        {
          if(Integer.parseInt(location_01.substring(2, 3)) == 0)
          {
            g.fillRect(600, 474, 6, 6);
          }
          else if(Integer.parseInt(location_01.substring(2, 3)) == 1)
          {
            g.fillRect(600, 396, 6, 6);
          }
          else if(Integer.parseInt(location_01.substring(2, 3)) == 2)
          {
            g.fillRect(600, 318, 6, 6);
          }
          else if(Integer.parseInt(location_01.substring(2, 3)) == 3)
          {
            g.fillRect(600, 240, 6, 6);
          }
        }
        else if(Integer.parseInt(location_01.substring(0, 1)) == 1)
        {
          if(Integer.parseInt(location_01.substring(2, 3)) == 0)
          {
            g.fillRect(678, 474, 6, 6);
          }
          else if(Integer.parseInt(location_01.substring(2, 3)) == 1)
          {
            g.fillRect(678, 396, 6, 6);
          }
          else if(Integer.parseInt(location_01.substring(2, 3)) == 2)
          {
            g.fillRect(678, 318, 6, 6);
          }
          else if(Integer.parseInt(location_01.substring(2, 3)) == 3)
          {
            g.fillRect(678, 240, 6, 6);
          }
        }
        else if(Integer.parseInt(location_01.substring(0, 1)) == 2)
        {
          if(Integer.parseInt(location_01.substring(2, 3)) == 0)
          {
            g.fillRect(756, 474, 6, 6);
          }
          else if(Integer.parseInt(location_01.substring(2, 3)) == 1)
          {
            g.fillRect(756, 396, 6, 6);
          }
          else if(Integer.parseInt(location_01.substring(2, 3)) == 2)
          {
            g.fillRect(756, 318, 6, 6);
          }
          else if(Integer.parseInt(location_01.substring(2, 3)) == 3)
          {
            g.fillRect(756, 240, 6, 6);
          }
        }
        else if(Integer.parseInt(location_01.substring(0, 1)) == 3)
        {
          if(Integer.parseInt(location_01.substring(2, 3)) == 0)
          {
            g.fillRect(834, 474, 6, 6);
          }
          else if(Integer.parseInt(location_01.substring(2, 3)) == 1)
          {
            g.fillRect(834, 396, 6, 6);
          }
          else if(Integer.parseInt(location_01.substring(2, 3)) == 2)
          {
            g.fillRect(834, 318, 6, 6);
          }
          else if(Integer.parseInt(location_01.substring(2, 3)) == 3)
          {
            g.fillRect(834, 240, 6, 6);
          }
        }

        /*
        g.setColor(Color.PINK);

        g.drawRect(588, 462, 30, 30);   //(0, 0)
        g.drawRect(666, 462, 30, 30);   //(1, 0)
        g.drawRect(744, 462, 30, 30);   //(2, 0)
        g.drawRect(822, 462, 30, 30);   //(3, 0)

        g.drawRect(588, 384, 30, 30);   //(0, 1)
        g.drawRect(666, 384, 30, 30);   //(1, 1)
        g.drawRect(744, 384, 30, 30);   //(2, 1)
        g.drawRect(822, 384, 30, 30);   //(3, 1)

        g.drawRect(588, 306, 30, 30);   //(0, 2)
        g.drawRect(666, 306, 30, 30);   //(1, 2)
        g.drawRect(744, 306, 30, 30);   //(2, 2)
        g.drawRect(822, 306, 30, 30);   //(3, 2)

        g.drawRect(588, 228, 30, 30);   //(0, 3)
        g.drawRect(666, 228, 30, 30);   //(1, 3)
        g.drawRect(744, 228, 30, 30);   //(2, 3)
        g.drawRect(822, 228, 30, 30);   //(3, 3)
        */
      }
    }
    public void startBattle()
    {
      //Random chance of starting a battle
      if(!disable_battleChance_01)
      {
        if(background == 600)
        {
          battleChance = (int)(Math.random()*5 + 0);
        }
      }
      else if(!disable_battleChance_02)
      {
        if(background == 1800)
        {
          battleChance = (int)(Math.random()*5 + 0);
        }
      }

      if(battleChance == 1 || battleChance == 2 || battleChance == 3 || battleChance == 4)
      {
        disable_moving_background = true;
      }

      if(background > 600)
      {
        disable_battleChance_01 = true;
      }

      if(background > 1800)
      {
        disable_battleChance_02 = true;
      }
    }
    public void resetMonster()
    {
      monster_health_01 = 0;
      monster_health_02 = 0;
      monster_health_03 = 0;

      witcher_select_01 = false;
      witcher_select_02 = false;
      witcher_select_03 = false;

      slot_select_weapon_1 = false;
      slot_select_weapon_2 = false;
      slot_select_weapon_3 = false;
      slot_select_weapon_4 = false;

      slot_select_potion_0 = false;
      slot_select_potion_1 = false;
      slot_select_potion_2 = false;

      slot_select_sign_1 = false;
      slot_select_sign_2 = false;
      slot_select_sign_3 = false;
      slot_select_sign_4 = false;
      slot_select_sign_5 = false;

      witcher_action_01 = 2;

      if(witcher_02_locked)
      {
        witcher_action_02 = 0;
      }
      else
      {
        witcher_action_02 = 2;
      }
      if(witcher_03_locked)
      {
        witcher_action_03 = 0;
      }
      else
      {
        witcher_action_03 = 2;
      }

      monster_action = 0;
    }
    public void reset()
    {
      witcher_action_01 = 2;

      if(witcher_02_locked)
      {
        witcher_action_02 = 0;
      }
      else
      {
        witcher_action_02 = 2;
      }
      if(witcher_03_locked)
      {
        witcher_action_03 = 0;
      }
      else
      {
        witcher_action_03 = 2;
      }

      monster_action = 0;

      witcher_health_01 = 0;
      witcher_health_02 = 0;
      witcher_health_03 = 0;

      monster_health_01 = 0;
      monster_health_02 = 0;
      monster_health_03 = 0;

      location_camp = true;
      location_road = false;
      battleChance = 0;
      disable_moving_background = false;
      disable_battleChance_01 = false;
      disable_battleChance_01 = false;
      location_01 = "0,0";
      location_02 = "";
      background = 0;
    }
    public void battleSound(int i)
    {
      //Plays sound
      try
      {
        AudioInputStream menu_close = AudioSystem.getAudioInputStream(this.getClass().getResource("menu_close.wav"));
        AudioInputStream kill_01 = AudioSystem.getAudioInputStream(this.getClass().getResource("kill_01.wav"));
        AudioInputStream kill_02 = AudioSystem.getAudioInputStream(this.getClass().getResource("kill_02.wav"));
        Clip clip = AudioSystem.getClip();

        if(i == 1)
        {
          clip.open(menu_close);
        }
        if(i == 2)
        {
          random_num_2 = (int)(Math.random()*2 + 0);

          if(random_num_2 == 0)
          {
            clip.open(kill_01);
          }
          else if(random_num_2 == 1)
          {
            clip.open(kill_02);
          }
        }
        clip.start();
      }
      catch(Exception e)
      {
        e.printStackTrace();
      }
    }
    public void walkingSound()
    {
      //Plays sound
      try
      {
        AudioInputStream foot_grass_w1 = AudioSystem.getAudioInputStream(this.getClass().getResource("foot_grass_w1.wav"));
        AudioInputStream foot_grass_w2 = AudioSystem.getAudioInputStream(this.getClass().getResource("foot_grass_w2.wav"));
        AudioInputStream foot_grass_w3 = AudioSystem.getAudioInputStream(this.getClass().getResource("foot_grass_w3.wav"));

        Clip clip = AudioSystem.getClip();

        random_num_3 = (int)(Math.random()*3 + 1);

        if(random_num_3 == 1)
        {
          clip.open(foot_grass_w1);
        }
        else if(random_num_3 == 2)
        {
          clip.open(foot_grass_w2);
        }
        else if(random_num_3 == 3)
        {
          clip.open(foot_grass_w3);
        }

        clip.start();
      }
      catch(Exception e)
      {
        e.printStackTrace();
      }
    }
    public void actionPerformed(ActionEvent evt)
    {
      if(evt.getSource() == timer)
      {
        tick++;

        if(tick == 2 || tick == 4 || tick == 6)
        {
          if(tick == 6)
          {
            witcher_action_01 = 2;

            if(!witcher_02_locked)
            {
              witcher_action_02 = 2;
            }
            if(!witcher_03_locked)
            {
              witcher_action_03 = 2;
            }
          }
          repaint();
        }
      }
    }
    public void keyTyped(KeyEvent e){}
    public void keyPressed(KeyEvent e)
    {
      //Uses arrow keys to "move" the character
      if(location_road && !disable_moving_background)
      {
        if(e.getKeyCode() == KeyEvent.VK_RIGHT)
        {
          moveFoward = true;

          if(background == 2400)
          {
            background = 2400;
          }
          else
          {
            background += 12;
          }

          if(background%72 == 0 && background != 2400)
          {
            walkingSound();
          }
        }
        else if(e.getKeyCode() == KeyEvent.VK_LEFT)
        {
          moveFoward = false;

          if(background == 0)
          {
            background = 0;
          }
          else
          {
            background -= 12;
          }

          if(background%72 == 0 && background != 0)
          {
            walkingSound();
          }
        }

        if(background == 2400)
        {
          location_camp = true;
          location_road = false;
          disable_battleChance_01 = false;
          disable_battleChance_01 = false;
          location_01 = location_02;
          location_02 = "";
          background = 0;

          if(Integer.parseInt(location_01.substring(0, 1)) >= 2 || Integer.parseInt(location_01.substring(2, 3)) >= 2)
          {
            witcher_02_locked = false;
          }
          if(Integer.parseInt(location_01.substring(0, 1)) >= 3 || Integer.parseInt(location_01.substring(2, 3)) >= 3)
          {
            witcher_03_locked = false;
          }
        }
      }

      //System.out.println(background + "\n");

      repaint();
    }
    public void keyReleased(KeyEvent e){}
    public void mouseClicked(MouseEvent e){}
    public void mousePressed(MouseEvent e)
    {
      //Uses mouse to select button
      requestFocus();

      if(!mouseEnabled)
      {
        return;
      }

      if(!slot_select_potion_0 && !slot_select_sign_0 && !slot_select_map)
      {
        //Surrender
        if(e.getX() >= 6 && e.getX() <= 66 && e.getY() >= 6 && e.getY() <= 66)
        {
          reset();
          cardLayout.show(cards, "panel_menu");
        }

        if(disable_moving_background)
        {
          /*
          //Witcher
          if(e.getX() >= 459 && e.getX() <= 564 && e.getY() >= 120 && e.getY() <= 330)
          {
            if(witcher_health_01_02/witcher_health_01_01 != 1)
            {
              witcher_health_01_02 += 5;
            }
            if(witcher_toxicity_01_02 > 0)
            {
              witcher_toxicity_01_02 -= 5;
            }
          }
          */

          if(e.getX() >= 423 && e.getX() <= 528 && e.getY() >= 114 && e.getY() <= 324)
          {
            witcher_select_01 = true;
            witcher_select_02 = false;
            witcher_select_03 = false;

            if(witcher_select_01)
            {
              if(slot_select_potion_1 && witcher_health_01 < witcher_health)
              {
                if(witcher_action_01 > 0)
                {
                  witcher_action_01--;
                  witcher_health_01 -= witcher_health/3;
                }
              }
              else if(slot_select_potion_2 && witcher_toxicity_01 > 0)
              {
                if(witcher_action_01 > 0)
                {
                  witcher_action_01--;
                  witcher_toxicity_01 += witcher_toxicity/3;

                  if(witcher_toxicity_01 >= 100)
                  {
                    witcher_toxicity_01 = 100;
                  }
                }
              }
            }
          }
          else if(e.getX() >= 246 && e.getX() <= 351 && e.getY() >= 114 && e.getY() <= 324)
          {
            if(!witcher_02_locked)
            {
              witcher_select_01 = false;
              witcher_select_02 = true;
              witcher_select_03 = false;

              if(witcher_select_02)
              {
                if(slot_select_potion_1 && witcher_health_02 < witcher_health)
                {
                  if(witcher_action_02 > 0)
                  {
                    witcher_action_02--;
                    witcher_health_02 -= witcher_health/3;
                  }
                }
                else if(slot_select_potion_2 && witcher_toxicity_02 > 0)
                {
                  if(witcher_action_02 > 0)
                  {
                    witcher_action_02--;
                    witcher_toxicity_02 += witcher_toxicity/3;

                    if(witcher_toxicity_02 >= 100)
                    {
                      witcher_toxicity_02 = 100;
                    }
                  }
                }
              }
            }
          }
          else if(e.getX() >= 69 && e.getX() <= 174 && e.getY() >= 114 && e.getY() <= 324)
          {
            if(!witcher_03_locked)
            {
              witcher_select_01 = false;
              witcher_select_02 = false;
              witcher_select_03 = true;

              if(witcher_select_03)
              {
                if(slot_select_potion_1 && witcher_health_03 < witcher_health)
                {
                  if(witcher_action_03 > 0)
                  {
                    witcher_action_03--;
                    witcher_health_03 -= witcher_health/3;
                  }
                }
                else if(slot_select_potion_2 && witcher_toxicity_03 > 0)
                {
                  if(witcher_action_03 > 0)
                  {
                    witcher_action_03--;
                    witcher_toxicity_03 += witcher_toxicity/3;

                    if(witcher_toxicity_03 >= 100)
                    {
                      witcher_toxicity_03 = 100;
                    }
                  }
                }
              }
            }
          }

          monsterButton(e);
        }
        weaponSlotButton(e);
      }

      mapSlotButton(e);
      potionSlotButton(e);
      signSlotButton(e);
      repaint();
    }
    public void weaponSlotButton(MouseEvent e)
    {
      //Weapon Slot
      if(witcher_select_01 || witcher_select_02 || witcher_select_03)
      {
        if(e.getX() >= 30 && e.getX() <= 90 && e.getY() >= 450 && e.getY() <= 570)
        {
          if(slot_select_weapon_1)
          {
            slot_select_weapon_1 = false;
          }
          else
          {
            slot_select_weapon_1 = true;
            slot_select_weapon_2 = false;
            slot_select_weapon_3 = false;
            slot_select_weapon_4 = false;

            slot_select_potion_0 = false;
            slot_select_potion_1 = false;
            slot_select_potion_2 = false;

            slot_select_sign_1 = false;
            slot_select_sign_2 = false;
            slot_select_sign_3 = false;
            slot_select_sign_4 = false;
            slot_select_sign_5 = false;
          }
        }
        else if(e.getX() >= 120 && e.getX() <= 180 && e.getY() >= 450 && e.getY() <= 570)
        {
          if(slot_select_weapon_2)
          {
            slot_select_weapon_2 = false;
          }
          else
          {
            slot_select_weapon_1 = false;
            slot_select_weapon_2 = true;
            slot_select_weapon_3 = false;
            slot_select_weapon_4 = false;

            slot_select_potion_0 = false;
            slot_select_potion_1 = false;
            slot_select_potion_2 = false;

            slot_select_sign_1 = false;
            slot_select_sign_2 = false;
            slot_select_sign_3 = false;
            slot_select_sign_4 = false;
            slot_select_sign_5 = false;
          }
        }
        else if(e.getX() >= 210 && e.getX() <= 270 && e.getY() >= 450 && e.getY() <= 570)
        {
          if(!slot_select_weapon_3_locked)
          {
            if(slot_select_weapon_3)
            {
              slot_select_weapon_3 = false;
            }
            else
            {
              slot_select_weapon_1 = false;
              slot_select_weapon_2 = false;
              slot_select_weapon_3 = true;
              slot_select_weapon_4 = false;

              slot_select_potion_0 = false;
              slot_select_potion_1 = false;
              slot_select_potion_2 = false;

              slot_select_sign_1 = false;
              slot_select_sign_2 = false;
              slot_select_sign_3 = false;
              slot_select_sign_4 = false;
              slot_select_sign_5 = false;
            }
          }
        }
        else if(e.getX() >= 300 && e.getX() <= 360 && e.getY() >= 450 && e.getY() <= 570)
        {
          if(!slot_select_weapon_4_locked)
          {
            if(slot_select_weapon_4)
            {
              slot_select_weapon_4 = false;
            }
            else
            {
              slot_select_weapon_1 = false;
              slot_select_weapon_2 = false;
              slot_select_weapon_3 = false;
              slot_select_weapon_4 = true;

              slot_select_potion_0 = false;
              slot_select_potion_1 = false;
              slot_select_potion_2 = false;

              slot_select_sign_1 = false;
              slot_select_sign_2 = false;
              slot_select_sign_3 = false;
              slot_select_sign_4 = false;
              slot_select_sign_5 = false;
            }
          }
        }
      }
    }
    public void mapSlotButton(MouseEvent e)
    {
      if(!slot_select_potion_0 && !slot_select_sign_0)
      {
        if(e.getX() >= 480 && e.getX() <= 540 && e.getY() >= 450 && e.getY() <= 510)
        {
          if(slot_select_map)
          {
            slot_select_map = false;
          }
          else
          {
            slot_select_map = true;
          }

          battleSound(1);
        }
      }

      if(location_camp && slot_select_map)
      {
        if(e.getX() >= 588 && e.getX() <= 618 && e.getY() >= 462 && e.getY() <= 492)
        {
          location_02 = "0,0";
          if(Math.abs(Integer.parseInt(location_01.substring(0, 1)) - Integer.parseInt(location_02.substring(0, 1))) == 1 ||
             Math.abs(Integer.parseInt(location_01.substring(2, 3)) - Integer.parseInt(location_02.substring(2, 3))) == 1)
          {
            if(Math.abs(Integer.parseInt(location_01.substring(0, 1)) - Integer.parseInt(location_02.substring(0, 1))) +
               Math.abs(Integer.parseInt(location_01.substring(2, 3)) - Integer.parseInt(location_02.substring(2, 3))) == 1)
            {
              location_camp = false;
              location_road = true;
              slot_select_map = false;
            }
          }
        }
        else if(e.getX() >= 666 && e.getX() <= 696 && e.getY() >= 462 && e.getY() <= 492)
        {
          location_02 = "1,0";
          if(Math.abs(Integer.parseInt(location_01.substring(0, 1)) - Integer.parseInt(location_02.substring(0, 1))) == 1 ||
             Math.abs(Integer.parseInt(location_01.substring(2, 3)) - Integer.parseInt(location_02.substring(2, 3))) == 1)
          {
            if(Math.abs(Integer.parseInt(location_01.substring(0, 1)) - Integer.parseInt(location_02.substring(0, 1))) +
               Math.abs(Integer.parseInt(location_01.substring(2, 3)) - Integer.parseInt(location_02.substring(2, 3))) == 1)
            {
              location_camp = false;
              location_road = true;
              slot_select_map = false;
            }
          }
        }
        else if(e.getX() >= 744 && e.getX() <= 774 && e.getY() >= 462 && e.getY() <= 492)
        {
          location_02 = "2,0";
          if(Math.abs(Integer.parseInt(location_01.substring(0, 1)) - Integer.parseInt(location_02.substring(0, 1))) == 1 ||
             Math.abs(Integer.parseInt(location_01.substring(2, 3)) - Integer.parseInt(location_02.substring(2, 3))) == 1)
          {
            if(Math.abs(Integer.parseInt(location_01.substring(0, 1)) - Integer.parseInt(location_02.substring(0, 1))) +
               Math.abs(Integer.parseInt(location_01.substring(2, 3)) - Integer.parseInt(location_02.substring(2, 3))) == 1)
            {
              location_camp = false;
              location_road = true;
              slot_select_map = false;
            }
          }
        }
        else if(e.getX() >= 822 && e.getX() <= 852 && e.getY() >= 462 && e.getY() <= 492)
        {
          location_02 = "3,0";
          if(Math.abs(Integer.parseInt(location_01.substring(0, 1)) - Integer.parseInt(location_02.substring(0, 1))) == 1 ||
             Math.abs(Integer.parseInt(location_01.substring(2, 3)) - Integer.parseInt(location_02.substring(2, 3))) == 1)
          {
            if(Math.abs(Integer.parseInt(location_01.substring(0, 1)) - Integer.parseInt(location_02.substring(0, 1))) +
               Math.abs(Integer.parseInt(location_01.substring(2, 3)) - Integer.parseInt(location_02.substring(2, 3))) == 1)
            {
              location_camp = false;
              location_road = true;
              slot_select_map = false;
            }
          }
        }
        else if(e.getX() >= 588 && e.getX() <= 618 && e.getY() >= 384 && e.getY() <= 414)
        {
          location_02 = "0,1";
          if(Math.abs(Integer.parseInt(location_01.substring(0, 1)) - Integer.parseInt(location_02.substring(0, 1))) == 1 ||
             Math.abs(Integer.parseInt(location_01.substring(2, 3)) - Integer.parseInt(location_02.substring(2, 3))) == 1)
          {
            if(Math.abs(Integer.parseInt(location_01.substring(0, 1)) - Integer.parseInt(location_02.substring(0, 1))) +
               Math.abs(Integer.parseInt(location_01.substring(2, 3)) - Integer.parseInt(location_02.substring(2, 3))) == 1)
            {
              location_camp = false;
              location_road = true;
              slot_select_map = false;
            }
          }
        }
        else if(e.getX() >= 666 && e.getX() <= 696 && e.getY() >= 384 && e.getY() <= 414)
        {
          location_02 = "1,1";
          if(Math.abs(Integer.parseInt(location_01.substring(0, 1)) - Integer.parseInt(location_02.substring(0, 1))) == 1 ||
             Math.abs(Integer.parseInt(location_01.substring(2, 3)) - Integer.parseInt(location_02.substring(2, 3))) == 1)
          {
            if(Math.abs(Integer.parseInt(location_01.substring(0, 1)) - Integer.parseInt(location_02.substring(0, 1))) +
               Math.abs(Integer.parseInt(location_01.substring(2, 3)) - Integer.parseInt(location_02.substring(2, 3))) == 1)
            {
              location_camp = false;
              location_road = true;
              slot_select_map = false;
            }
          }
        }
        else if(e.getX() >= 744 && e.getX() <= 774 && e.getY() >= 384 && e.getY() <= 414)
        {
          location_02 = "2,1";
          if(Math.abs(Integer.parseInt(location_01.substring(0, 1)) - Integer.parseInt(location_02.substring(0, 1))) == 1 ||
             Math.abs(Integer.parseInt(location_01.substring(2, 3)) - Integer.parseInt(location_02.substring(2, 3))) == 1)
          {
            if(Math.abs(Integer.parseInt(location_01.substring(0, 1)) - Integer.parseInt(location_02.substring(0, 1))) +
               Math.abs(Integer.parseInt(location_01.substring(2, 3)) - Integer.parseInt(location_02.substring(2, 3))) == 1)
            {
              location_camp = false;
              location_road = true;
              slot_select_map = false;
            }
          }
        }
        else if(e.getX() >= 822 && e.getX() <= 852 && e.getY() >= 384 && e.getY() <= 414)
        {
          location_02 = "3,1";
          if(Math.abs(Integer.parseInt(location_01.substring(0, 1)) - Integer.parseInt(location_02.substring(0, 1))) == 1 ||
             Math.abs(Integer.parseInt(location_01.substring(2, 3)) - Integer.parseInt(location_02.substring(2, 3))) == 1)
          {
            if(Math.abs(Integer.parseInt(location_01.substring(0, 1)) - Integer.parseInt(location_02.substring(0, 1))) +
               Math.abs(Integer.parseInt(location_01.substring(2, 3)) - Integer.parseInt(location_02.substring(2, 3))) == 1)
            {
              location_camp = false;
              location_road = true;
              slot_select_map = false;
            }
          }
        }
        else if(e.getX() >= 588 && e.getX() <= 618 && e.getY() >= 306 && e.getY() <= 336)
        {
          location_02 = "0,2";
          if(Math.abs(Integer.parseInt(location_01.substring(0, 1)) - Integer.parseInt(location_02.substring(0, 1))) == 1 ||
             Math.abs(Integer.parseInt(location_01.substring(2, 3)) - Integer.parseInt(location_02.substring(2, 3))) == 1)
          {
            if(Math.abs(Integer.parseInt(location_01.substring(0, 1)) - Integer.parseInt(location_02.substring(0, 1))) +
               Math.abs(Integer.parseInt(location_01.substring(2, 3)) - Integer.parseInt(location_02.substring(2, 3))) == 1)
            {
              location_camp = false;
              location_road = true;
              slot_select_map = false;
            }
          }
        }
        else if(e.getX() >= 666 && e.getX() <= 696 && e.getY() >= 306 && e.getY() <= 336)
        {
          location_02 = "1,2";
          if(Math.abs(Integer.parseInt(location_01.substring(0, 1)) - Integer.parseInt(location_02.substring(0, 1))) == 1 ||
             Math.abs(Integer.parseInt(location_01.substring(2, 3)) - Integer.parseInt(location_02.substring(2, 3))) == 1)
          {
            if(Math.abs(Integer.parseInt(location_01.substring(0, 1)) - Integer.parseInt(location_02.substring(0, 1))) +
               Math.abs(Integer.parseInt(location_01.substring(2, 3)) - Integer.parseInt(location_02.substring(2, 3))) == 1)
            {
              location_camp = false;
              location_road = true;
              slot_select_map = false;
            }
          }
        }
        else if(e.getX() >= 744 && e.getX() <= 774 && e.getY() >= 306 && e.getY() <= 336)
        {
          location_02 = "2,2";
          if(Math.abs(Integer.parseInt(location_01.substring(0, 1)) - Integer.parseInt(location_02.substring(0, 1))) == 1 ||
             Math.abs(Integer.parseInt(location_01.substring(2, 3)) - Integer.parseInt(location_02.substring(2, 3))) == 1)
          {
            if(Math.abs(Integer.parseInt(location_01.substring(0, 1)) - Integer.parseInt(location_02.substring(0, 1))) +
               Math.abs(Integer.parseInt(location_01.substring(2, 3)) - Integer.parseInt(location_02.substring(2, 3))) == 1)
            {
              location_camp = false;
              location_road = true;
              slot_select_map = false;
            }
          }
        }
        else if(e.getX() >= 822 && e.getX() <= 852 && e.getY() >= 306 && e.getY() <= 336)
        {
          location_02 = "3,2";
          if(Math.abs(Integer.parseInt(location_01.substring(0, 1)) - Integer.parseInt(location_02.substring(0, 1))) == 1 ||
             Math.abs(Integer.parseInt(location_01.substring(2, 3)) - Integer.parseInt(location_02.substring(2, 3))) == 1)
          {
            if(Math.abs(Integer.parseInt(location_01.substring(0, 1)) - Integer.parseInt(location_02.substring(0, 1))) +
               Math.abs(Integer.parseInt(location_01.substring(2, 3)) - Integer.parseInt(location_02.substring(2, 3))) == 1)
            {
              location_camp = false;
              location_road = true;
              slot_select_map = false;
            }
          }
        }
        else if(e.getX() >= 588 && e.getX() <= 618 && e.getY() >= 228 && e.getY() <= 258)
        {
          location_02 = "0,3";
          if(Math.abs(Integer.parseInt(location_01.substring(0, 1)) - Integer.parseInt(location_02.substring(0, 1))) == 1 ||
             Math.abs(Integer.parseInt(location_01.substring(2, 3)) - Integer.parseInt(location_02.substring(2, 3))) == 1)
          {
            if(Math.abs(Integer.parseInt(location_01.substring(0, 1)) - Integer.parseInt(location_02.substring(0, 1))) +
               Math.abs(Integer.parseInt(location_01.substring(2, 3)) - Integer.parseInt(location_02.substring(2, 3))) == 1)
            {
              location_camp = false;
              location_road = true;
              slot_select_map = false;
            }
          }
        }
        else if(e.getX() >= 666 && e.getX() <= 696 && e.getY() >= 228 && e.getY() <= 258)
        {
          location_02 = "1,3";
          if(Math.abs(Integer.parseInt(location_01.substring(0, 1)) - Integer.parseInt(location_02.substring(0, 1))) == 1 ||
             Math.abs(Integer.parseInt(location_01.substring(2, 3)) - Integer.parseInt(location_02.substring(2, 3))) == 1)
          {
            if(Math.abs(Integer.parseInt(location_01.substring(0, 1)) - Integer.parseInt(location_02.substring(0, 1))) +
               Math.abs(Integer.parseInt(location_01.substring(2, 3)) - Integer.parseInt(location_02.substring(2, 3))) == 1)
            {
              location_camp = false;
              location_road = true;
              slot_select_map = false;
            }
          }
        }
        else if(e.getX() >= 744 && e.getX() <= 774 && e.getY() >= 228 && e.getY() <= 258)
        {
          location_02 = "2,3";
          if(Math.abs(Integer.parseInt(location_01.substring(0, 1)) - Integer.parseInt(location_02.substring(0, 1))) == 1 ||
             Math.abs(Integer.parseInt(location_01.substring(2, 3)) - Integer.parseInt(location_02.substring(2, 3))) == 1)
          {
            if(Math.abs(Integer.parseInt(location_01.substring(0, 1)) - Integer.parseInt(location_02.substring(0, 1))) +
               Math.abs(Integer.parseInt(location_01.substring(2, 3)) - Integer.parseInt(location_02.substring(2, 3))) == 1)
            {
              location_camp = false;
              location_road = true;
              slot_select_map = false;
            }
          }
        }
        else if(e.getX() >= 822 && e.getX() <= 852 && e.getY() >= 228 && e.getY() <= 258)
        {
          location_02 = "3,3";
          if(Math.abs(Integer.parseInt(location_01.substring(0, 1)) - Integer.parseInt(location_02.substring(0, 1))) == 1 ||
             Math.abs(Integer.parseInt(location_01.substring(2, 3)) - Integer.parseInt(location_02.substring(2, 3))) == 1)
          {
            if(Math.abs(Integer.parseInt(location_01.substring(0, 1)) - Integer.parseInt(location_02.substring(0, 1))) +
               Math.abs(Integer.parseInt(location_01.substring(2, 3)) - Integer.parseInt(location_02.substring(2, 3))) == 1)
            {
              location_camp = false;
              location_road = true;
              slot_select_map = false;
            }
          }
        }
        battleSound(1);
      }
    }
    public void potionSlotButton(MouseEvent e)
    {
      if(witcher_select_01 || witcher_select_02 || witcher_select_03)
      {
        if(!slot_select_map && !slot_select_sign_0)
        {
          if(e.getX() >= 480 && e.getX() <= 540 && e.getY() >= 360 && e.getY() <= 420)
          {
            slot_select_weapon_1 = false;
            slot_select_weapon_2 = false;
            slot_select_weapon_3 = false;
            slot_select_weapon_4 = false;

            slot_select_sign_1 = false;
            slot_select_sign_2 = false;
            slot_select_sign_3 = false;
            slot_select_sign_4 = false;
            slot_select_sign_5 = false;

            if(slot_select_potion_0)
            {
              slot_select_potion_0 = false;
              slot_select_potion_1 = true;
              slot_select_potion_2 = false;
            }
            else
            {
              slot_select_potion_0 = true;
              slot_select_potion_1 = false;
              slot_select_potion_2 = false;
            }
          }
          else if(e.getX() >= 570 && e.getX() <= 660 && e.getY() >= 360 && e.getY() <= 420)
          {
            if(slot_select_potion_0)
            {
              slot_select_potion_0 = false;
              slot_select_potion_1 = false;
              slot_select_potion_2 = true;
            }
          }
        }
      }
    }
    public void signSlotButton(MouseEvent e)
    {
      if(witcher_select_01 || witcher_select_02 || witcher_select_03)
      {
        if(!slot_select_map && !slot_select_potion_0)
        {
          if(e.getX() >= 390 && e.getX() <= 450 && e.getY() >= 450 && e.getY() <= 510)
          {
            slot_select_weapon_1 = false;
            slot_select_weapon_2 = false;
            slot_select_weapon_3 = false;
            slot_select_weapon_4 = false;

            slot_select_potion_1 = false;
            slot_select_potion_2 = false;

            if(slot_select_sign_0)
            {
              slot_select_sign_0 = false;
              slot_select_sign_1 = true;
              slot_select_sign_2 = false;
              slot_select_sign_3 = false;
              slot_select_sign_4 = false;
              slot_select_sign_5 = false;
            }
            else
            {
              slot_select_sign_0 = true;
              slot_select_sign_1 = false;
              slot_select_sign_2 = false;
              slot_select_sign_3 = false;
              slot_select_sign_4 = false;
              slot_select_sign_5 = false;
            }
          }
          else if(e.getX() >= 480 && e.getX() <= 540 && e.getY() >= 450 && e.getY() <= 510)
          {
            if(slot_select_sign_0)
            {
              slot_select_sign_0 = false;
              slot_select_sign_1 = false;
              slot_select_sign_2 = true;
              slot_select_sign_3 = false;
              slot_select_sign_4 = false;
              slot_select_sign_5 = false;
            }
          }
          else if(e.getX() >= 570 && e.getX() <= 630 && e.getY() >= 450 && e.getY() <= 510)
          {
            if(slot_select_sign_0)
            {
              slot_select_sign_0 = false;
              slot_select_sign_1 = false;
              slot_select_sign_2 = false;
              slot_select_sign_3 = true;
              slot_select_sign_4 = false;
              slot_select_sign_5 = false;
            }
          }
          else if(e.getX() >= 660 && e.getX() <= 720 && e.getY() >= 450 && e.getY() <= 510)
          {
            if(slot_select_sign_0)
            {
              slot_select_sign_0 = false;
              slot_select_sign_1 = false;
              slot_select_sign_2 = false;
              slot_select_sign_3 = false;
              slot_select_sign_4 = true;
              slot_select_sign_5 = false;
            }
          }
          else if(e.getX() >= 750 && e.getX() <= 810 && e.getY() >= 450 && e.getY() <= 510)
          {
            if(slot_select_sign_0)
            {
              slot_select_sign_0 = false;
              slot_select_sign_1 = false;
              slot_select_sign_2 = false;
              slot_select_sign_3 = false;
              slot_select_sign_4 = false;
              slot_select_sign_5 = true;
            }
          }
        }
      }
    }
    public void monsterButton(MouseEvent e)
    {
      if(e.getX() >= 669 && e.getX() <= 774 && e.getY() >= 114 && e.getY() <= 324)
      {
        if(monster_health_01 < monster_health)
        {
          if(monster_health_01 >= monster_health)
          {
            monster_health_01 = monster_health;
          }
          else
          {
            if(witcher_select_01 && slot_select_weapon_2)
            {
              if(witcher_action_01 > 0)
              {
                witcher_action_01--;
                monster_health_01 += 5*2;
                battleSound(2);
              }
            }
            else if(witcher_select_02 && slot_select_weapon_2)
            {
              if(witcher_action_02 > 0)
              {
                witcher_action_02--;
                monster_health_01 += 5*2;
                battleSound(2);
              }
            }
            else if(witcher_select_03 && slot_select_weapon_2)
            {
              if(witcher_action_03 > 0)
              {
                witcher_action_03--;
                monster_health_01 += 5*2;
                battleSound(2);
              }
            }
            else if(witcher_select_01 && slot_select_weapon_1)
            {
              if(witcher_action_01 > 0)
              {
                witcher_action_01--;
                monster_health_01 += 5;
                battleSound(2);
              }
            }
            else if(witcher_select_02 && slot_select_weapon_1)
            {
              if(witcher_action_02 > 0)
              {
                witcher_action_02--;
                monster_health_01 += 5;
                battleSound(2);
              }
            }
            else if(witcher_select_03 && slot_select_weapon_1)
            {
              if(witcher_action_03 > 0)
              {
                witcher_action_03--;
                monster_health_01 += 5;
                battleSound(2);
              }
            }
          }
        }
      }
      else if(e.getX() >= 846 && e.getX() <= 951 && e.getY() >= 114 && e.getY() <= 324)
      {
        if(monster_health_02 < monster_health)
        {
          if(monster_health_02 >= monster_health)
          {
            monster_health_02 = monster_health;
          }
          else
          {
            if(witcher_select_01 && slot_select_weapon_2)
            {
              if(witcher_action_01 > 0)
              {
                witcher_action_01--;
                monster_health_02 += 5*2;
                battleSound(2);
              }
            }
            else if(witcher_select_02 && slot_select_weapon_2)
            {
              if(witcher_action_02 > 0)
              {
                witcher_action_02--;
                monster_health_02 += 5*2;
                battleSound(2);
              }
            }
            else if(witcher_select_03 && slot_select_weapon_2)
            {
              if(witcher_action_03 > 0)
              {
                witcher_action_03--;
                monster_health_02 += 5*2;
                battleSound(2);
              }
            }
            else if(witcher_select_01 && slot_select_weapon_1)
            {
              if(witcher_action_01 > 0)
              {
                witcher_action_01--;
                monster_health_02 += 5;
                battleSound(2);
              }
            }
            else if(witcher_select_02 && slot_select_weapon_1)
            {
              if(witcher_action_02 > 0)
              {
                witcher_action_02--;
                monster_health_02 += 5;
                battleSound(2);
              }
            }
            else if(witcher_select_03 && slot_select_weapon_1)
            {
              if(witcher_action_03 > 0)
              {
                witcher_action_03--;
                monster_health_02 += 5;
                battleSound(2);
              }
            }
          }
        }
      }
      else if(e.getX() >= 1023 && e.getX() <= 1128 && e.getY() >= 114 && e.getY() <= 324)
      {
        if(monster_health_03 < monster_health)
        {
          if(monster_health_03 >= monster_health)
          {
            monster_health_03 = monster_health;
          }
          else
          {
            if(witcher_select_01 && slot_select_weapon_2)
            {
              if(witcher_action_01 > 0)
              {
                witcher_action_01--;
                monster_health_03 += 5*2;
                battleSound(2);
              }
            }
            else if(witcher_select_02 && slot_select_weapon_2)
            {
              if(witcher_action_02 > 0)
              {
                witcher_action_02--;
                monster_health_03 += 5*2;
                battleSound(2);
              }
            }
            else if(witcher_select_03 && slot_select_weapon_2)
            {
              if(witcher_action_03 > 0)
              {
                witcher_action_03--;
                monster_health_03 += 5*2;
                battleSound(2);
              }
            }
            else if(witcher_select_01 && slot_select_weapon_1)
            {
              if(witcher_action_01 > 0)
              {
                witcher_action_01--;
                monster_health_03 += 5;
                battleSound(2);
              }
            }
            else if(witcher_select_02 && slot_select_weapon_1)
            {
              if(witcher_action_02 > 0)
              {
                witcher_action_02--;
                monster_health_03 += 5;
                battleSound(2);
              }
            }
            else if(witcher_select_03 && slot_select_weapon_1)
            {
              if(witcher_action_03 > 0)
              {
                witcher_action_03--;
                monster_health_03 += 5;
                battleSound(2);
              }
            }
          }
        }
      }

      if(witcher_action_01 + witcher_action_02 + witcher_action_03 == 0)
      {
        monster_action = 3;
        witcher_select_01 = false;
        witcher_select_02 = false;
        witcher_select_03 = false;
      }

      if(monster_health_01 + monster_health_02 + monster_health_03 >= monster_health*3)
      {
        if(!disable_battleChance_01 && background == 600)
        {
          disable_battleChance_01 = true;
        }
        if(!disable_battleChance_02 && background == 1800)
        {
          disable_battleChance_02 = true;
        }

        battleChance = 0;
        disable_moving_background = false;
        resetMonster();
      }
    }
    public void mouseReleased(MouseEvent e){}
    public void mouseEntered(MouseEvent e){}
    public void mouseExited(MouseEvent e){}
    public void mouseMoved(MouseEvent e){}
    public void mouseDragged(MouseEvent e){}
  }
}
