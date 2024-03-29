package ihm;

import java.awt.Image;
import java.awt.Toolkit;


public class ImagesManager {

	/**
     * Les fichiers images
     */
	protected Image imgIcon = null;
    protected Image imgChariot = null;
    protected Image imgChariotSel = null;
    protected Image imgChariotB = null;
    protected Image imgChariotBSel = null;
    protected Image imgEtincelles = null;
    protected Image imgNode = null;
    protected Image imgNodeSel = null;
    protected Image imgNodeGarage = null;
    protected Image imgNodeGarageSel = null;
    protected Image imgGuichet = null;
    protected Image imgGuichetSel = null;
    protected Image imgToboggan = null;
    protected Image imgTobogganSel = null;
    protected Image imgTapis = null;
    protected Image imgTapisSel = null;
    protected Image imgTapisB = null;
    protected Image imgTapisBSel = null;
    protected Image imgRail = null;
    protected Image imgRailSel = null;
    
    protected String PATH_IMAGE;
    protected String IMG_ICON;
    protected String IMG_CHARIOT;
    protected String IMG_CHARIOT_B;
    protected String IMG_NODE;
    protected String IMG_NODE_GARAGE;
	protected String IMG_GUICHET;
	protected String IMG_TOBOGGAN;
	protected String IMG_TAPIS;
	protected String IMG_TAPIS_B;
	protected String IMG_RAIL;
	protected String IMG_CHARIOT_SEL;
	protected String IMG_CHARIOT_B_SEL;
	protected String IMG_ETINCELLES;
	protected String IMG_NODE_SEL;
	protected String IMG_NODE_GARAGE_SEL;
	protected String IMG_GUICHET_SEL;
	protected String IMG_TOBOGGAN_SEL;
	protected String IMG_TAPIS_SEL;
	protected String IMG_TAPIS_B_SEL;
	protected String IMG_RAIL_SEL;
	
    public ImagesManager(Toolkit tk, int styleId) {
    	
    	if (styleId == 0)
    		PATH_IMAGE = "res/img/";
    	else if (styleId == 1)
    		PATH_IMAGE = "res/img/christmas/";
    	
    	IMG_ICON = PATH_IMAGE+"icon_logo.png";
        IMG_CHARIOT = PATH_IMAGE+"chariot.png";
        IMG_CHARIOT_B = PATH_IMAGE+"chariot_b.png";
        IMG_NODE = PATH_IMAGE+"node.png";
        IMG_NODE_GARAGE = PATH_IMAGE+"node_garage.png";
        IMG_GUICHET = PATH_IMAGE+"guichet.png";
        IMG_TOBOGGAN = PATH_IMAGE+"toboggan.png";
        IMG_TAPIS = PATH_IMAGE+"tapis.png";
        IMG_TAPIS_B = PATH_IMAGE+"tapis_b.png";
        IMG_RAIL = PATH_IMAGE+"rail.png";
        IMG_CHARIOT_SEL = PATH_IMAGE+"chariot_sel.png";
        IMG_CHARIOT_B_SEL = PATH_IMAGE+"chariot_b_sel.png";
        IMG_ETINCELLES = PATH_IMAGE+"etoiles.png";
        IMG_NODE_SEL = PATH_IMAGE+"node_sel.png";
        IMG_NODE_GARAGE_SEL = PATH_IMAGE+"node_garage_sel.png";
        IMG_GUICHET_SEL = PATH_IMAGE+"guichet_sel.png";
        IMG_TOBOGGAN_SEL = PATH_IMAGE+"toboggan_sel.png";
        IMG_TAPIS_SEL = PATH_IMAGE+"tapis_sel.png";
        IMG_TAPIS_B_SEL = PATH_IMAGE+"tapis_b_sel.png";
        IMG_RAIL_SEL = PATH_IMAGE+"rail_sel.png";
    	
    	imgIcon = tk.getImage(IMG_ICON);
    	imgChariot = tk.getImage(IMG_CHARIOT);
    	imgChariotSel = tk.getImage(IMG_CHARIOT_SEL);
    	imgChariotB = tk.getImage(IMG_CHARIOT_B);
    	imgChariotBSel = tk.getImage(IMG_CHARIOT_B_SEL);
    	imgEtincelles = tk.getImage(IMG_ETINCELLES);
    	imgNode = tk.getImage(IMG_NODE);
    	imgNodeSel = tk.getImage(IMG_NODE_SEL);
    	imgNodeGarage = tk.getImage(IMG_NODE_GARAGE);
    	imgNodeGarageSel = tk.getImage(IMG_NODE_GARAGE_SEL);
    	imgGuichet = tk.getImage(IMG_GUICHET);
    	imgGuichetSel = tk.getImage(IMG_GUICHET_SEL);
    	imgToboggan = tk.getImage(IMG_TOBOGGAN);
    	imgTobogganSel = tk.getImage(IMG_TOBOGGAN_SEL);
    	imgTapis = tk.getImage(IMG_TAPIS);
    	imgTapisSel = tk.getImage(IMG_TAPIS_SEL);
    	imgTapisB = tk.getImage(IMG_TAPIS_B);
    	imgTapisBSel = tk.getImage(IMG_TAPIS_B_SEL);
    	imgRail = tk.getImage(IMG_RAIL);
    	imgRailSel = tk.getImage(IMG_RAIL_SEL);
	}
    
    public Image getImgIcon() {
		return imgIcon;
	}
    
    public Image getImgChariotSel() {
		return imgChariotSel;
	}

	public Image getImgChariotBSel() {
		return imgChariotBSel;
	}

	public Image getImgEtincelles() {
		return imgEtincelles;
	}

	public Image getImgNodeSel() {
		return imgNodeSel;
	}

	public Image getImgNodeGarageSel() {
		return imgNodeGarageSel;
	}

	public Image getImgGuichetSel() {
		return imgGuichetSel;
	}

	public Image getImgTobogganSel() {
		return imgTobogganSel;
	}

	public Image getImgTapisSel() {
		return imgTapisSel;
	}

	public Image getImgTapisBSel() {
		return imgTapisBSel;
	}

	public Image getImgRailSel() {
		return imgRailSel;
	}

	public Image getImgChariot() {
		return imgChariot;
	}

	public Image getImgChariotB() {
		return imgChariotB;
	}

	public Image getImgNode() {
		return imgNode;
	}

	public Image getImgNodeGarage() {
		return imgNodeGarage;
	}

	public Image getImgGuichet() {
		return imgGuichet;
	}

	public Image getImgToboggan() {
		return imgToboggan;
	}

	public Image getImgTapis() {
		return imgTapis;
	}

	public Image getImgTapisB() {
		return imgTapisB;
	}

	public Image getImgRail() {
		return imgRail;
	}

}
