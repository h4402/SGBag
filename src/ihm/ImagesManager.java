package ihm;

import java.awt.Image;
import java.awt.Toolkit;


public class ImagesManager {

	/**
     * Les fichiers images
     */
    private Image imgChariot = null;
    private Image imgChariotSel = null;
    private Image imgChariotB = null;
    private Image imgChariotBSel = null;
    private Image imgNode = null;
    private Image imgNodeSel = null;
    private Image imgNodeGarage = null;
    private Image imgNodeGarageSel = null;
    private Image imgGuichet = null;
    private Image imgGuichetSel = null;
    private Image imgToboggan = null;
    private Image imgTobogganSel = null;
    private Image imgTapis = null;
    private Image imgTapisSel = null;
    private Image imgTapisB = null;
    private Image imgTapisBSel = null;
    private Image imgRail = null;
    private Image imgRailSel = null;
    
    final String PATH_IMAGE = "res/img/";
    final String IMG_CHARIOT = PATH_IMAGE+"chariot.png";
    final String IMG_CHARIOT_B = PATH_IMAGE+"chariot_b.png";
    final String IMG_NODE = PATH_IMAGE+"node.png";
    final String IMG_NODE_GARAGE = PATH_IMAGE+"node_garage.png";
    final String IMG_GUICHET = PATH_IMAGE+"guichet.png";
    final String IMG_TOBOGGAN = PATH_IMAGE+"toboggan.png";
    final String IMG_TAPIS = PATH_IMAGE+"tapis.png";
    final String IMG_TAPIS_B = PATH_IMAGE+"tapis_b.png";
    final String IMG_RAIL = PATH_IMAGE+"rail.png";
    final String IMG_CHARIOT_SEL = PATH_IMAGE+"chariot_sel.png";
    final String IMG_CHARIOT_B_SEL = PATH_IMAGE+"chariot_b_sel.png";
    final String IMG_NODE_SEL = PATH_IMAGE+"node_sel.png";
    final String IMG_NODE_GARAGE_SEL = PATH_IMAGE+"node_garage_sel.png";
    final String IMG_GUICHET_SEL = PATH_IMAGE+"guichet_sel.png";
    final String IMG_TOBOGGAN_SEL = PATH_IMAGE+"toboggan_sel.png";
    final String IMG_TAPIS_SEL = PATH_IMAGE+"tapis_sel.png";
    final String IMG_TAPIS_B_SEL = PATH_IMAGE+"tapis_b_sel.png";
    final String IMG_RAIL_SEL = PATH_IMAGE+"rail_sel.png";
	
    public ImagesManager() {
    	Toolkit tk = Toolkit.getDefaultToolkit();
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

	public String getPATH_IMAGE() {
		return PATH_IMAGE;
	}

	public String getIMG_CHARIOT() {
		return IMG_CHARIOT;
	}

	public String getIMG_CHARIOT_B() {
		return IMG_CHARIOT_B;
	}

	public String getIMG_NODE() {
		return IMG_NODE;
	}

	public String getIMG_NODE_GARAGE() {
		return IMG_NODE_GARAGE;
	}

	public String getIMG_GUICHET() {
		return IMG_GUICHET;
	}

	public String getIMG_TOBOGGAN() {
		return IMG_TOBOGGAN;
	}

	public String getIMG_TAPIS() {
		return IMG_TAPIS;
	}

	public String getIMG_TAPIS_B() {
		return IMG_TAPIS_B;
	}

	public String getIMG_RAIL() {
		return IMG_RAIL;
	}
    
}
