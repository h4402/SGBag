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
    
    protected final String PATH_IMAGE = "res/img/";
    protected final String IMG_ICON = PATH_IMAGE+"icon_logo.png";
    protected final String IMG_CHARIOT = PATH_IMAGE+"chariot.png";
    protected final String IMG_CHARIOT_B = PATH_IMAGE+"chariot_b.png";
    protected final String IMG_NODE = PATH_IMAGE+"node.png";
    protected final String IMG_NODE_GARAGE = PATH_IMAGE+"node_garage.png";
    protected final String IMG_GUICHET = PATH_IMAGE+"guichet.png";
    protected final String IMG_TOBOGGAN = PATH_IMAGE+"toboggan.png";
    protected final String IMG_TAPIS = PATH_IMAGE+"tapis.png";
    protected final String IMG_TAPIS_B = PATH_IMAGE+"tapis_b.png";
    protected final String IMG_RAIL = PATH_IMAGE+"rail.png";
    protected final String IMG_CHARIOT_SEL = PATH_IMAGE+"chariot_sel.png";
    protected final String IMG_CHARIOT_B_SEL = PATH_IMAGE+"chariot_b_sel.png";
    protected final String IMG_NODE_SEL = PATH_IMAGE+"node_sel.png";
    protected final String IMG_NODE_GARAGE_SEL = PATH_IMAGE+"node_garage_sel.png";
    protected final String IMG_GUICHET_SEL = PATH_IMAGE+"guichet_sel.png";
    protected final String IMG_TOBOGGAN_SEL = PATH_IMAGE+"toboggan_sel.png";
    protected final String IMG_TAPIS_SEL = PATH_IMAGE+"tapis_sel.png";
    protected final String IMG_TAPIS_B_SEL = PATH_IMAGE+"tapis_b_sel.png";
    protected final String IMG_RAIL_SEL = PATH_IMAGE+"rail_sel.png";
	
    public ImagesManager(Toolkit tk) {
    	//Toolkit tk = Toolkit.getDefaultToolkit();
    	imgIcon = tk.getImage(IMG_ICON);
    	imgChariot = tk.getImage(IMG_CHARIOT);
    	imgChariotSel = tk.getImage(IMG_CHARIOT_SEL);
    	imgChariotB = tk.getImage(IMG_CHARIOT_B);
    	imgChariotBSel = tk.getImage(IMG_CHARIOT_B_SEL);
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
