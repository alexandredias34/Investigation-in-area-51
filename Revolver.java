
public class Revolver extends Item
{
    private boolean aAssembled;
    private boolean aLoaded;
    /**
     * Constructeur de Revolver
     * @param pItemName est le nom de l'Item
     * @param pItemDesc est la description de l'Item
     */
    public Revolver(final String pItemName, final String pItemDesc)
    {
        super(pItemName, pItemDesc, 3, false);
        aAssembled = false;
        aLoaded = false;
    }//Revolver(..)
    /**
     * Assemblage du Revolver
     */
    public void assemble ()
    {
        this.setDescription ("The revolver is assembled. You only need one bullet to get the job done now."); 
        this.aAssembled = true;
        this.setWeight(4);
    }//assemble()
    /**
     * Getter de statut de Revolver
     * @return le booléen indiquant s'il est assemblé
     */
    public boolean isAssembled ()
    {
        return this.aAssembled;
    }//isAssembled()
    /**
     * Chargement du Revolver
     */
    public void load ()
    {
        this.setDescription ("The revolver is assembled, and loaded. Ready to shoot (not your foot, preferably)!"); 
        this.aLoaded = true;
        this.setWeight(5);
    }//load()
    /**
     * Getter de statut de revolver
     * @return le booléen indiquant s'il est chargé
     */
    public boolean isLoaded ()
    {
        return this.aLoaded;
    }//isLoaded
    /**
     * Modification du revolver après avoir tiré
     */
    public void shoot()
    {
        this.setDescription("The revolver needs to be reloaded. Find a .50 cal bullet.");
        this.aLoaded= false;
        this.setWeight(4);
    }//shoot()

}