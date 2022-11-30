import java.util.Stack;
/**
 * Décrivez votre classe Player ici.
 *
 * @author (votre nom)
 * @version (un numéro de version ou une date)
 */
public class Player
{
    private Room aCurrentRoom;
    private String aPlayerName;
    private Stack<Room> aPreviousRooms;
    private ItemList aInventory;
    private double aMaxWeight;
    private double aWeight;
    /**
     * Constructeur de classe Player
     * @param Le nom du joueur
     */
    public Player(final String pPlayerName)
    {

        this.aCurrentRoom =null; 
        this.aPlayerName = pPlayerName;
        this.aPreviousRooms = new Stack<Room>();
        this.aInventory = new ItemList();
        this.aMaxWeight = 20;
        this.aWeight = 0;
    }//Player(.)
    /**
     * Accesseur retournant le nom du joueur
     * @return aPlayerName est le nom du joueur
     */
    public String getPlayerName(){return this.aPlayerName;}//getPlayerName()
    /**
     * Accesseur retournant la Room dans laquelle se trouve le joueur
     * @return aCurrentRoom est la Room dans laquelle se trouve le joueur
     */
    public Room getCurrentRoom(){return this.aCurrentRoom;}//getCurrentRoom()
    /**
     * Modificateur changeant la Room dans laquelle se trouve le joueur
     * @param pRoom est la Room devant devenir la Room actuelle
     */
    public void setCurrentRoom(final Room pRoom){ this.aCurrentRoom = pRoom;}//setCurrentRoom(.)

    /**
     * Accesseur retournant la Stack contenant les Room parcourues
     * @return aPreviousRooms est la pile des Rooms parcourues
     */
    public Stack getPreviousRooms(){return this.aPreviousRooms;}//getPreviousRooms()
    /**
     * Ajoute la Room actuelle à la Stack des Room parcourues, puis change de Room actuelle
     * @param pRoom est la Room suivante
     */
    public void changeRoom(final Room pRoom)
    {
        this.aPreviousRooms.add(this.aCurrentRoom);
        this.aCurrentRoom=pRoom;
    }//changeRoom(.)
    /**
     * Retourne les noms et poids des Items portés par le joueur
     * @return vReturnString contient les noms et poids des items que l'on a
     */
    public String getInventoryString()
    {
        if(this.aInventory.getItemString()!=""){

            String vReturnString = "You are carrying :"+this.aInventory.getShortItemString();
            return vReturnString;
        }
        else { return "You're not carrying anything.";}
    }//getInventoryString()
    /**
     * Accesseur retournant l'inventaire du joueur
     * @return aInventory l'ItemList contenant les Items du joueur
     */
    public ItemList getInventory() { return this.aInventory;}//getInventory()
    /**
     * Accesseur retournant le poids max porté par le joueur
     * @return aMaxWeight le poids max porté par le joueur
     */
    public double getMaxWeight(){return this.aMaxWeight;}//getMaxWeight()
    /**
     * Modificateur permettant de changer le poids maximum porté par le joueur
     * @param pMaxWeight est un double représentant le nouveau poids max porté
     */
    public void setMaxWeight(final double pMaxWeight)
    {
        this.aMaxWeight = pMaxWeight;   
    }//setMaxWeight(.)
    /**
     *Accesseur permettant de connaitre le poids total des items sur le joueur
     *@return aWeight le double représentant le poids total des items
     */
    public double getWeight(){return this.aWeight;}//getWeight()

    /**
     * Modificateur permettant de modifier le poids total des items du joueur
     * @param pWeight est le nouveau poids transporté par le joueur
     */
    public void setWeight(final double pWeight)
    {this.aWeight = pWeight;}//setWeight(.)

    /**
     * Test permettant de savoir si le joueur a la capacité d'emporter un objet donné
     * @param pWeight est un double contenant le poids de l'objet testé
     * @return true si l'objet peut être ramassé sans dépasser le poids max
     */
    public boolean canTake(final double pWeight)
    {
        return (pWeight + this.aWeight <= this.aMaxWeight);
    }//canTake(.) 
    /**
     *Procédure supprimant la liste des rooms précédentes ( à employer avec TrapDoor)
     *
     */
    public void clearPreviousRooms(){this.aPreviousRooms.clear();}//clearPreviousRooms()

}
