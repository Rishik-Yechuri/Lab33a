import java.awt.*;
import java.awt.event.*;

public class Lab33a {
    public static void main(String[] args) {
        GfxApp gfx = new GfxApp();
        gfx.setSize(1000, 750);
        gfx.addWindowListener(new WindowAdapter() {
            public void
            windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
        gfx.show();
    }
}


class GfxApp extends Frame {

    private final int td = 1300;        // time delay to slow down graphics display

    public void paint(Graphics g) {
        g.setFont(new Font("ARIAL", Font.BOLD, 28));
        g.drawString("LAB 33A 80/100 POINT VERSION", 300, 50);
        g.setFont(new Font("ARIAL", Font.BOLD, 20));
        g.drawString("DRAWING A LINKED LIST AS A STACK", 50, 215);
        g.drawString("DRAWING A LINKED LIST AS A QUEUE", 50, 415);    // for 100 point version only
        drawStack(g);
        drawQueue(g);                                                // for 100 point version only
    }

    public void drawStack(Graphics g) {
        //p = new node...
        GfxNode node1 = new GfxNode(g, 700, 200, 'P', 0, td);
        node1.enterData(g, 'A', 0);
        GfxNode.delay(td);
        //next = null
        node1.drawNull(g, 0);
        GfxNode.delay(td);
        //temp = p
        node1.drawPointer(g, 'T', 2, 0);
        GfxNode.delay(td);

        //p = new node...
        node1.drawPointer(g, 'P', 1, 9);
        GfxNode.delay(td);
        GfxNode node2 = new GfxNode(g, 600, 200, 'P', 0, td);
        node2.enterData(g, 'B', 0);
        GfxNode.delay(td);
        //next = node1
        node2.drawLink(g, node1, 0);
        GfxNode.delay(td);
        //temp = p
        node1.drawPointer(g, 'T', 2, 9);
        node2.drawPointer(g, 'T', 2, 0);
        GfxNode.delay(td);

        //p = new node...
        node2.drawPointer(g, 'P', 1, 9);
        GfxNode.delay(td);
        GfxNode node3 = new GfxNode(g, 500, 200, 'P', 0, td);
        node3.enterData(g, 'C', 0);
        GfxNode.delay(td);
        //next = node1
        node3.drawLink(g, node2, 0);
        GfxNode.delay(td);
        //temp = p
        node2.drawPointer(g, 'T', 2, 9);
        node3.drawPointer(g, 'T', 2, 0);
        GfxNode.delay(td);


    }


    public void drawQueue(Graphics g) {
        //Create a new node
        GfxNode node1 = new GfxNode(g, 500, 400, 'F', 0, td);
        //Enter data and draw it
        node1.enterData(g, 'A', 0);
        node1.drawNull(g, 0);
        node1.drawPointer(g, 'T', 2, 0);

        //Create another new node
        GfxNode node2 = new GfxNode(g, 600, 400, 'P', 0, td);
        //Enter data and draw it
        node2.enterData(g, 'B', 0);
        GfxNode.delay(td);
        node2.drawNull(g, 0);
        GfxNode.delay(td);
        //Draw some more stuff
        node1.drawNull(g, 9);
        GfxNode.delay(td);
        node1.drawLink(g, node2, 0);
        GfxNode.delay(td);
        node1.drawPointer(g, 'T', 2, 9);
        node2.drawPointer(g, 'T', 2, 0);
        GfxNode.delay(td);
        node2.drawPointer(g, 'P', 1, 9);
        GfxNode.delay(td);

        //Create the 3rd node
        GfxNode node3 = new GfxNode(g, 700, 400, 'P', 0, td);
        //Enter data and draw stuff
        node3.enterData(g, 'C', 0);
        GfxNode.delay(td);
        node3.drawNull(g, 0);
        GfxNode.delay(td);
        node2.drawNull(g, 9);
        GfxNode.delay(td);
        node2.drawLink(g, node3, 0);
        GfxNode.delay(td);
        node2.drawPointer(g, 'T', 2, 9);
        node3.drawPointer(g, 'T', 2, 0);
        GfxNode.delay(td);
    }
}
class GfxNode {
    private final int x;
    private final int y;
    private final int width;
    private final int height;
    private final int time;

    public GfxNode(Graphics g, int tlx, int tly, char ltr, int clr, int dt) {
        x = tlx;
        y = tly;
        width = 30;
        height = 15;
        time = dt;
        drawNode(g, clr);
        drawPointer(g, ltr, 1, clr);
    }

    private void drawNode(Graphics g, int clr) {
        g.setColor(getColor(clr));
        g.drawRect(x, y, width, height);
        g.drawLine(x + height, y, x + height, y + height);
        delay(time);
    }

    private Color getColor(int clr) {
        Color temp = Color.white;
        switch (clr) {
            case 0:
                temp = Color.black;
                break;
            case 1:
                temp = Color.red;
                break;
            case 2:
                temp = Color.green;
                break;
            case 3:
                temp = Color.blue;
                break;
            case 4:
                temp = Color.orange;
                break;
            case 5:
                temp = Color.cyan;
                break;
            case 6:
                temp = Color.magenta;
                break;
            case 7:
                temp = Color.yellow;
                break;
            case 8:
                temp = Color.pink;
                break;
            case 9:
                temp = Color.white;
                break;
        }
        return temp;
    }

    public int getx() {
        return x;
    }

    public int gety() {
        return y;
    }

    public void drawPointer(Graphics g, char ltr, int offSet, int clr) {
        if (offSet == 1) {
            offSet = 8;
        } else {
            offSet = 18;
        }
        int x1 = x + offSet;
        int y1 = y - 20;
        int x2 = x1;
        int y2 = y - 2;
        g.setColor(getColor(clr));
        g.drawLine(x1, y1, x2, y2);
        g.drawLine(x2, y2, x2 - 3, y2 - 3);
        g.drawLine(x2, y2, x2 + 3, y2 - 3);
        drawLetter(g, ltr, x + offSet - 4, y - 32);
        delay(time);
    }

    public static void delay(double n) {
        for (double k = 1; k < n; k += 0.00001) ;
    }

    public void enterData(Graphics g, char ltr, int clr) {
        g.setColor(getColor(clr));
        drawLetter(g, ltr, x + 3, y + 3);
        delay(time);
    }

    public void drawLink(Graphics g, GfxNode endNode, int clr) {
        int x1, x2;
        int y1 = this.gety() + height / 2;
        int y2 = endNode.gety() + height / 2;
        g.setColor(getColor(clr));
        if (this.getx() < endNode.getx()) {
            x1 = this.getx() + 22;
            x2 = endNode.getx() - 2;
            g.drawLine(x1, y1, x2, y2);
            g.drawLine(x2, y2, x2 - 3, y2 - 3);
            g.drawLine(x2, y2, x2 - 3, y2 + 3);
        } else {
            x1 = endNode.getx() + 8;
            x2 = this.getx() + width + 2;
            g.drawLine(x1, y1, x2, y2);
            g.drawLine(x1, y1, x1 - 3, y1 - 3);
            g.drawLine(x1, y1, x1 - 3, y1 + 3);
        }
        delay(time);
    }

    public void drawNull(Graphics g, int clr) {
        g.setColor(getColor(clr));
        g.drawLine(x + height + 1, y + 1, x + width - 1, y + height - 1);
        delay(time);
    }

    public void drawLetter(Graphics g, char ltr, int x, int y) {
        switch (ltr) {
            case 'A':
                g.drawLine(x, y, x, y + 8);
                g.drawLine(x + 8, y, x + 8, y + 8);
                g.drawLine(x, y, x + 8, y);
                g.drawLine(x, y + 4, x + 8, y + 4);
                break;
            case 'B':
                g.drawLine(x, y, x, y + 8);
                g.drawLine(x, y, x + 5, y);
                g.drawLine(x, y + 8, x + 5, y + 8);
                g.drawLine(x, y + 4, x + 5, y + 4);
                g.drawLine(x + 5, y, x + 8, y + 2);
                g.drawLine(x + 5, y + 8, x + 8, y + 6);
                g.drawLine(x + 5, y + 4, x + 8, y + 2);
                g.drawLine(x + 5, y + 4, x + 8, y + 6);
                break;
            case 'C':
                g.drawLine(x, y, x, y + 8);
                g.drawLine(x, y, x + 8, y);
                g.drawLine(x, y + 8, x + 8, y + 8);
                break;
            case 'D':
                g.drawLine(x, y, x, y + 8);
                g.drawLine(x, y, x + 4, y);
                g.drawLine(x, y + 8, x + 4, y + 8);
                g.drawLine(x + 4, y, x + 8, y + 4);
                g.drawLine(x + 4, y + 8, x + 8, y + 4);
                break;
            case 'E':
                g.drawLine(x, y, x, y + 8);
                g.drawLine(x, y, x + 8, y);
                g.drawLine(x, y + 8, x + 8, y + 8);
                g.drawLine(x, y + 4, x + 6, y + 4);
                break;
            case 'F':
                g.drawLine(x, y, x, y + 8);
                g.drawLine(x, y, x + 8, y);
                g.drawLine(x, y + 4, x + 6, y + 4);
                break;
            case 'G':
                g.drawLine(x, y, x, y + 8);
                g.drawLine(x, y, x + 6, y);
                g.drawLine(x, y + 8, x + 8, y + 8);
                g.drawLine(x + 8, y + 8, x + 8, y + 4);
                g.drawLine(x + 8, y + 4, x + 4, y + 4);
                break;
            case 'H':
                g.drawLine(x, y, x, y + 8);
                g.drawLine(x + 8, y, x + 8, y + 8);
                g.drawLine(x, y + 4, x + 8, y + 4);
                break;
            case 'I':
                g.drawLine(x, y, x + 8, y);
                g.drawLine(x, y + 8, x + 8, y + 8);
                g.drawLine(x + 4, y, x + 4, y + 8);
                break;
            case 'J':
                g.drawLine(x + 8, y, x + 8, y + 8);
                g.drawLine(x, y + 8, x + 8, y + 8);
                g.drawLine(x, y + 8, x, y + 4);
                break;
            case 'K':
                g.drawLine(x, y, x, y + 8);
                g.drawLine(x + 8, y, x + 1, y + 4);
                g.drawLine(x + 8, y + 8, x + 1, y + 4);
                break;
            case 'L':
                g.drawLine(x, y, x, y + 8);
                g.drawLine(x, y + 8, x + 8, y + 8);
                break;
            case 'M':
                g.drawLine(x, y, x, y + 8);
                g.drawLine(x + 8, y, x + 8, y + 8);
                g.drawLine(x, y, x + 5, y + 5);
                g.drawLine(x + 8, y + 1, x + 4, y + 4 + 1);
                break;
            case 'N':
                g.drawLine(x, y, x, y + 8);
                g.drawLine(x + 8, y, x + 8, y + 8);
                g.drawLine(x, y, x + 9 - 1, y + 8);
                break;
            case 'O':
                g.drawLine(x, y, x, y + 8);
                g.drawLine(x + 8, y, x + 8, y + 8);
                g.drawLine(x, y, x + 8, y);
                g.drawLine(x, y + 8, x + 8, y + 8);
                break;
            case 'P':
                g.drawLine(x, y, x, y + 8);
                g.drawLine(x, y, x + 8, y);
                g.drawLine(x, y + 4, x + 8, y + 4);
                g.drawLine(x + 8, y, x + 8, y + 4);
                break;
            case 'Q':
                g.drawLine(x, y, x, y + 8);
                g.drawLine(x + 8, y, x + 8, y + 8);
                g.drawLine(x, y, x + 8, y);
                g.drawLine(x, y + 8, x + 8, y + 8);
                g.drawLine(x + 3, y + 5, x + 8, y + 10);
                break;
            case 'R':
                g.drawLine(x, y, x, y + 8);
                g.drawLine(x, y, x + 8, y);
                g.drawLine(x, y + 4, x + 8, y + 4);
                g.drawLine(x + 8, y, x + 8, y + 4);
                g.drawLine(x, y + 4, x + 9, y + 8);
                break;
            case 'S':
                g.drawLine(x, y, x + 8, y);
                g.drawLine(x, y + 4, x + 8, y + 4);
                g.drawLine(x, y + 8, x + 8, y + 8);
                g.drawLine(x, y, x, y + 4);
                g.drawLine(x + 8, y + 4, x + 8, y + 8);
                break;
            case 'T':
                g.drawLine(x, y, x + 8, y);
                g.drawLine(x + 4, y, x + 4, y + 8);
                break;
            case 'U':
                g.drawLine(x, y, x, y + 8);
                g.drawLine(x + 8, y, x + 8, y + 8);
                g.drawLine(x, y + 8, x + 8, y + 8);
                break;
            case 'V':
                g.drawLine(x, y, x + 4, y + 8);
                g.drawLine(x + 8, y, x + 4, y + 8);
                break;
            case 'W':
                g.drawLine(x, y, x, y + 8);
                g.drawLine(x + 8, y, x + 8, y + 9 - 1);
                g.drawLine(x, y + 8, x + 4, y + 4);
                g.drawLine(x + 8, y + 8, x + 4, y + 4);
                break;
            case 'x':
                g.drawLine(x, y, x + 9, y + 8);
                g.drawLine(x, y + 8, x + 8, y);
                break;
            case 'y':
                g.drawLine(x, y, x + 5 - 1, y + 4);
                g.drawLine(x + 8, y, x + 4, y + 4);
                g.drawLine(x + 4, y + 4, x + 4, y + 8);
                break;
            case 'Z':
                g.drawLine(x, y, x + 8, y);
                g.drawLine(x, y + 8, x + 8, y + 8);
                g.drawLine(x + 8, y, x, y + 8);
                break;
            default:
                g.fillRect(x, y, 8, 8);
        }
    }
}