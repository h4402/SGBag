package ihm;

import java.awt.Image;
import java.awt.Toolkit;


public class ImagesManager {

	/**
     * Les fichiers images
     */
    private Image imgChariot = null;
    private Image imgChariotB = null;
    private Image imgNode = null;
    private Image imgNodeGarage = null;
    private Image imgGuichet = null;
    private Image imgToboggan = null;
    private Image imgTapis = null;
    private Image imgTapisB = null;
    private Image imgRail = null;
    
    final String PATH_IMAGE = "res/img/";
    final String IMG_CHARIOT = PATH_IMAGE+"chariot.png";
    final String IMG_CHARIOT_B = PATH_IMAGE+"chariot_b.png";
    final String IMG_NODE = PATH_IMAGE+"node.png";
    final String IMG_NODE_GARAGE = PATH_IMAGE+"node_garage.png";
    final String IMG_GUICHET = PATH_IMAGE+"node.png";
    final String IMG_TOBOGGAN = PATH_IMAGE+"toboggan.png";
    final String IMG_TAPIS = PATH_IMAGE+"tapis.png";
    final String IMG_TAPIS_B = PATH_IMAGE+"tapis_b.png";
    final String IMG_RAIL = PATH_IMAGE+"rail.png";
	
    public ImagesManager() {
    	Toolkit tk = Toolkit.getDefaultToolkit();
    	imgChariot = tk.getImage(IMG_CHARIOT);
    	imgChariotB = tk.getImage(IMG_CHARIOT_B);
    	imgNode = tk.getImage(IMG_NODE);
    	imgNodeGarage = tk.getImage(IMG_NODE_GARAGE);
    	imgGuichet = tk.getImage(IMG_GUICHET);
    	imgToboggan = tk.getImage(IMG_TOBOGGAN);
    	imgTapis = tk.getImage(IMG_TAPIS);
    	imgTapisB = tk.getImage(IMG_TAPIS_B);
    	imgRail = tk.getImage(IMG_RAIL);
    	
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
