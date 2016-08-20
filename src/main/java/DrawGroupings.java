import java.awt.*;
import java.awt.geom.*;
import java.util.*;

/**
 * This class draws groups on the Karnaugh Map
 * @author Horatiu Lazu
 * @version 1.0
 */
public class DrawGroupings {
    /** groups LinkedList These are the groups */
    private LinkedList <Grouping> groups;
    /** variables int This is the number of variables */
    private int variables;
    /** g2 Graphics2D This is the graphics 2D object */
    private Graphics2D g2;
    /** colors Color [] This is the colors array */
    private Color [] colors = {
            new Color(0x673ab7),
            new Color(0x00e676),
            new Color(0xe91e63),
            new Color(0x2196f3),
            new Color(0x009688),
            new Color(0xff5722)
    };
    /** GROUPING_THICKNESS int This is the thickness */
    public static final int GROUPING_THICKNESS = 2;
    /** tick int This is the tick value */
    private int tick = 0;
    /** START_X int This is the starting x value */
    final int START_X = 270;
    /** START_Y int This is the starting y value */
    final int START_Y = 50;

    /**
     * This is the class constructor that gets the data.
     * @param groups LinkedList This stores the groups
     * @param variables variable The number of variables
     * @param g2 Graphics2D This is the graphics reference
     */
    public DrawGroupings(LinkedList<Grouping> groups, int variables, Graphics2D g2){
        this.groups = groups;
        this.variables = variables;
        this.g2 = g2;
    }

    /**
     * Draws the groups depending on the groups linked list.
     */
    public void drawGroups(){
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setStroke(new BasicStroke(DrawGroupings.GROUPING_THICKNESS));

        for (Grouping group : groups){

            final int DIST = (variables == 2) ? (200) : (100); //size of box
            final int CURVE = (variables == 2) ? (100) : (50);

            tick(g2);
            g2.draw(new RoundRectangle2D.Float(
                    START_X + DIST * group.getStartX(),
                    START_Y + DIST * group.getStartY(),
                    DIST * (group.getEndX()-group.getStartX()+1),
                    DIST * (group.getEndY()-group.getStartY()+1),
                    CURVE,
                    CURVE));
        }
        drawMatrixLabelling();
    }


    /**
     * This method draws the 1 values (and don't cares) on the matrix.
     */
    public void drawMatrixLabelling(){
        g2.setColor(Color.BLACK);
        final int DIST = (variables == 2) ? (200) : (100);
        for(int y = 0; y < Solve.matrix[0].length; y++){
            for(int x = 0; x < Solve.matrix.length; x++){
                if (Solve.matrix[x][y] == 1){
                    g2.drawString("1", START_X + DIST * x + DIST/2 -5, START_Y + DIST * y + DIST/2 +5);
                }
            }
        }
    }

    /**
     * This is the tick for the color of the groups.
     * @param g2 Graphics This is the graphics reference.
     */
    private void tick(Graphics g2){
        tick = (tick+1)%colors.length;
        g2.setColor(colors[tick]);
    }
}
