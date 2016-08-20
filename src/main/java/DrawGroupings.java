import javax.swing.*;
import java.awt.*;
import java.awt.geom.*;
import java.util.*;

/**
 * Created by horatiulazu on 2016-08-20.
 */
public class DrawGroupings {
    private LinkedList <Grouping> groups;
    private int variables;
    private Graphics2D g2;
    private Color [] colors = {
            new Color(0x673ab7),
            new Color(0x00e676),
            new Color(0xe91e63),
            new Color(0x2196f3),
            new Color(0x009688),
            new Color(0xff5722)
    };
    public static final int GROUPING_THICKNESS = 2;
    private int tick = 0;
    final int START_X = 270;
    final int START_Y = 50;

    public DrawGroupings(LinkedList<Grouping> groups, int variables, Graphics2D g2){
        this.groups = groups;
        this.variables = variables;
        this.g2 = g2;
    }

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

    private void tick(Graphics g2){
        tick = (tick+1)%colors.length;
        g2.setColor(colors[tick]);
    }
}
