package player;

import java.awt.Image;

import zones.LimitedZone;
import zones.OrderedZone;

/**
 * @author joelmanning
 *
 */
public class Player
{
    public static final int HAND_SIZE = 10;
    public static final int BOARD_SIZE = 7;
    public static final int STARTING_HAND_SIZE = 3;
    private OrderedZone graveyard;
    private OrderedZone deck;
    private LimitedZone battlefield;
    private LimitedZone hand;
    private Portrait portrait;
}
