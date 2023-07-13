/*

    Gallardo Morales, Juan Carlos - jcgallardomorales@gmail.com
    Izquierdo Vera, Javier - javieriizquierdovera@gmail.com

 */
package sistemaSolar;

import com.sun.j3d.utils.geometry.Primitive;
import com.sun.j3d.utils.geometry.Sphere;
import com.sun.j3d.utils.image.TextureLoader;
import com.sun.j3d.utils.universe.SimpleUniverse;
import com.sun.j3d.utils.universe.Viewer;
import com.sun.j3d.utils.universe.ViewingPlatform;
import java.util.ArrayList;
import java.util.HashMap;
import javax.media.j3d.Appearance;
import javax.media.j3d.Background;
import javax.media.j3d.BoundingSphere;
import javax.media.j3d.BranchGroup;
import javax.media.j3d.Locale;
import javax.media.j3d.Material;
import javax.media.j3d.Texture;
import javax.media.j3d.TransformGroup;
import javax.vecmath.Color3f;
import javax.vecmath.Point3d;

public class Universo {
    private Nave nave;
    private HashMap<String,Astro> astros;
    final int TRASLADO_SOL = 200000;
    final int TRASLADO_ORB = 200000;
    final float SCALE = 0.1f;
    Locale locale;
    SimpleUniverse simpleUniverse;
    private BranchGroup vistas = new BranchGroup();
    
    

    public Universo (){
        this.nave = null;
        this.astros = new HashMap();
    }
    
    public int getNumComponentes(){
        int total = astros.size();
        if (nave != null)
            total++;
        return total;
    }

    public Nave getNave() {
        return nave;
    }

    public void setNave(Nave nave) {
        this.nave = nave;
    }

    public HashMap<String,Astro> getAstros() {
        return astros;
    }
    
    public ArrayList<Astro> getAstrosArray(){
        ArrayList<Astro> as = new ArrayList();
        
        for (Astro value : astros.values()) {
            as.add(value);
        }
        
        return as;
        
    }

    public void setAstros(HashMap<String,Astro> astros) {
        this.astros = astros;
    }
    
    public void addAstro(Astro ast){
        astros.put(ast.getNombre(),ast);
    }
    
    public int numAstros(){
        return astros.size();
    }
    
    public void crearSistemaSolar(){
        String dir_text_sol = "src/texturas_estrellas/";
        String dir_text_sat = "src/texturas_satelites/";
        String dir_text_pla = "src/texturas_planetas/";
        
        Material m_planetas = new Material();
        m_planetas.setAmbientColor(0.5f, 0.5f, 0.5f);
        m_planetas.setDiffuseColor(1.0f, 1.0f, 1.0f);
        m_planetas.setSpecularColor(0.3f, 0.3f, 0.3f);
        
        Material m_sol = new Material();
        m_sol.setAmbientColor(1.0f,0.5f,0.5f);
        m_sol.setDiffuseColor(1.0f, 1.0f, 1.0f);
        m_sol.setEmissiveColor(1.0f, 1.0f, 1.0f);
        
        /*
        
        nombre
        radio
        distancia
        archivo_textura
        material
        color
        rotacion
        traslacion
        
        radio_false
        distancia_false
        rotacion_false
        traslacion_false
        
        
        */
        
        // ESTRELLAS --> SOL
        
        Astro sol = new Estrella("sol", 696342, dir_text_sol + "sol.jpg", m_sol, 
                26,/*radio_false*/25*SCALE,/*distancia_false*/0*SCALE,
                /*rotacion_false*/TRASLADO_SOL,/*traslacion_false*/0);
        astros.put(sol.getNombre(),sol);
        
        // SATÉLITES
        Astro luna = new Satelite("luna", 1737, 370300, dir_text_sat + "luna.jpg", m_planetas,
                27.32, 27.32,2*SCALE/*radio_false*/,/*distancia_false*/4*SCALE,
                /*rotacion_false*/TRASLADO_SOL+TRASLADO_SOL/10000,/*traslacion_false*/TRASLADO_ORB/10);
        astros.put(luna.getNombre(), luna);
        
        Astro fobos = new Satelite("fobos", 11, 9380, dir_text_sat + "fobos.jpg", m_planetas, 
                0.3 , 0.3,2*SCALE/*radio_false*/,/*distancia_false*/5*SCALE,
                /*rotacion_false*/TRASLADO_SOL/30,/*traslacion_false*/TRASLADO_ORB/17);
        astros.put(fobos.getNombre(), fobos);
        
        Astro deimos = new Satelite("deimos",7,23460, dir_text_sat + "deimos.jpg", m_planetas, 
                1.25,1.25,2*SCALE/*radio_false*/,/*distancia_false*/5*SCALE,
                /*rotacion_false*/TRASLADO_SOL/18,/*traslacion_false*/TRASLADO_ORB/14); 
        astros.put(deimos.getNombre(), deimos);
        
        Astro io = new Satelite("io",1820,422000, dir_text_sat + "io.jpg", m_planetas, 
                1.75,1.75,3*SCALE/*radio_false*/,/*distancia_false*/8*SCALE,
                /*rotacion_false*/TRASLADO_SOL/17,/*traslacion_false*/TRASLADO_ORB/14);
        astros.put(io.getNombre(),io);
        
        Astro europa = new Satelite("europa",1561, 671000, dir_text_sat + "europa.jpg", m_planetas, 
                3.54,3.54,3*SCALE/*radio_false*/,/*distancia_false*/7*SCALE,
                /*rotacion_false*/TRASLADO_SOL/16,/*traslacion_false*/TRASLADO_ORB/13);
        astros.put(europa.getNombre(), europa);
        
        Astro calisto = new Satelite("calisto",2410, 1880000, dir_text_sat + "calisto.jpg", m_planetas, 
                16.7, 16.7,4*SCALE/*radio_false*/,/*distancia_false*/5*SCALE,
                /*rotacion_false*/TRASLADO_SOL/14,/*traslacion_false*/TRASLADO_ORB/11);
        astros.put(calisto.getNombre(), calisto);
        
        Astro titania = new Satelite("titania",788, 436000, dir_text_sat + "titania.jpg", m_planetas, 
                8.7, 8.7,3*SCALE/*radio_false*/,/*distancia_false*/5*SCALE,
                /*rotacion_false*/TRASLADO_SOL/15,/*traslacion_false*/TRASLADO_ORB/12);
        astros.put(titania.getNombre(), titania);
        
        Astro ariel = new Satelite("ariel", (float) 578.5, 190000, dir_text_sat + "ariel.jpg", m_planetas, 
                2.52,2.52,3*SCALE/*radio_false*/,/*distancia_false*/5*SCALE,
                /*rotacion_false*/TRASLADO_SOL/18,/*traslacion_false*/TRASLADO_ORB/13);
        astros.put(titania.getNombre(), titania);
        
        Astro miranda = new Satelite("miranda",236, 130000 ,dir_text_sat + "miranda.jpg", m_planetas, 
                1.41,1.41,2*SCALE/*radio_false*/,/*distancia_false*/5*SCALE,
                /*rotacion_false*/TRASLADO_SOL/19,/*traslacion_false*/TRASLADO_ORB/14);
        astros.put(miranda.getNombre(), miranda);
        
        Astro triton = new Satelite("triton", (float) 1353.5, 354760, dir_text_sat + "triton.jpg", m_planetas, 
                -5.88,-5.88,4*SCALE/*radio_false*/,/*distancia_false*/5*SCALE,
                /*rotacion_false*/-TRASLADO_SOL/15,/*traslacion_false*/TRASLADO_ORB/-12);
        astros.put(triton.getNombre(), triton);
        
        // *******************************************************************/
        //Planetas
        // distancia respecto al sol expresados en millones de km
        // radio expresado en km
        // rotación y traslación expresados en días
        // *******************************************************************/
        
        Astro mercurio = new Planeta("mercurio", (float) 2439.7, (float) 57.8, dir_text_pla + "mercurio.jpg", m_planetas, 
                58.6, 87.6, (Estrella) sol, null,6*SCALE/*radio_false*/,
                10*SCALE/*distancia_false*/,/*rotacion_false*/TRASLADO_SOL/10,/*traslacion_false*/TRASLADO_ORB/14);
        
        Astro venus = new Planeta("venus",6052, (float) 108.2, dir_text_pla + "venus.jpg", m_planetas, 
                243 , 224.5, (Estrella) sol, null,8*SCALE/*radio_false*/,
                20*SCALE/*distancia_false*/,/*rotacion_false*/TRASLADO_SOL/5,/*traslacion_false*/TRASLADO_ORB/11);
        
        Astro tierra = new Planeta("tierra", 6378, (float) 149.6, dir_text_pla + "tierra.jpg", m_planetas, 
                 1, 365.25, (Estrella) sol, new HashMap(),8*SCALE/*radio_false*/,
                30*SCALE/*distancia_false*/,/*rotacion_false*/TRASLADO_SOL/20,/*traslacion_false*/TRASLADO_ORB/8);
        
            ((Planeta) tierra).addSatelite((Satelite) luna);
            
            
            
        Astro marte = new Planeta("marte", (float) 3393.5, (float) 227.9, dir_text_pla + "marte.jpg", m_planetas, 
                1.03, 686.6, (Estrella) sol, new HashMap(),6*SCALE/*radio_false*/,
                40*SCALE/*distancia_false*/,/*rotacion_false*/TRASLADO_SOL/20,/*traslacion_false*/TRASLADO_ORB/7);
        
            ((Planeta) marte).addSatelite((Satelite) fobos);
            ((Planeta) marte).addSatelite((Satelite) deimos);
            
            
        Astro jupiter = new Planeta("jupiter",71492, (float) 778.5, dir_text_pla + "jupiter.jpg", m_planetas, 
                0.414, 4331.86, (Estrella) sol, new HashMap(),/*radio_false*/15*SCALE,
                60*SCALE/*distancia_false*/,/*rotacion_false*/TRASLADO_SOL/25,/*traslacion_false*/TRASLADO_ORB/5);
        
            ((Planeta) jupiter).addSatelite((Satelite) io);
            ((Planeta) jupiter).addSatelite((Satelite) europa);
            ((Planeta) jupiter).addSatelite((Satelite) calisto);
        Astro saturno = new Planeta("saturno",60268, 1433, dir_text_pla + "saturno.jpg", m_planetas, 
                 0.426, 10760.27, (Estrella) sol, null,/*radio_false*/13*SCALE,
                80*SCALE/*distancia_false*/,/*rotacion_false*/TRASLADO_SOL/25,/*traslacion_false*/TRASLADO_ORB/3); 
            Anillo anillo_a = new Anillo("anillo a",saturno.getRadioFalse()* 1.7, dir_text_pla + "anillo_saturno.png",m_planetas);
            //Anillo anillo_b = new Anillo("anillo b",saturno.getRadioFalse()* 1.8, dir_text_pla + "anillo_saturno.png",m_planetas,Color.white);
            //Anillo anillo_c = new Anillo("anillo c",saturno.getRadioFalse()* 2.0, dir_text_pla + "anillo_saturno.png",m_planetas,Color.white);

            ((Planeta)saturno).addAnillo(anillo_a);
            //saturno.addAnillo(anillo_b);
            //saturno.addAnillo(anillo_c);
            
            /*********  3 anillos representados en una textura ************/
            
        Astro urano = new Planeta("urano", 25554, 2877, dir_text_pla + "urano.jpg", m_planetas, 
                0.718, 30684, (Estrella) sol, new HashMap(),/*radio_false*/10*SCALE,
                90*SCALE/*distancia_false*/,/*rotacion_false*/TRASLADO_SOL/23,/*traslacion_false*/TRASLADO_ORB/2);
        
            ((Planeta) urano).addSatelite((Satelite) titania);
            ((Planeta) urano).addSatelite((Satelite) ariel);
            ((Planeta) urano).addSatelite((Satelite) miranda);
            
            
        Astro neptuno = new Planeta("neptuno", 24769, 4498, dir_text_pla + "neptuno.jpg", m_planetas, 
                0.6745, 60189, (Estrella) sol, new HashMap(),/*radio_false*/10*SCALE,
                100*SCALE/*distancia_false*/,/*rotacion_false*/TRASLADO_SOL/24,/*traslacion_false*/TRASLADO_ORB);
        
        
            ((Planeta) neptuno).addSatelite((Satelite) triton);
            
            
            
        astros.put(mercurio.getNombre(), mercurio);
        astros.put(venus.getNombre(), venus);
        astros.put(tierra.getNombre(), tierra);
        astros.put(marte.getNombre(), marte);
        astros.put(jupiter.getNombre(), jupiter);
        astros.put(saturno.getNombre(), saturno);
        astros.put(urano.getNombre(), urano);
        astros.put(neptuno.getNombre(), neptuno);
    }
    
    public void createUniverso(){
        simpleUniverse = new SimpleUniverse(null);
        simpleUniverse.getViewer().setVisible(false);
        simpleUniverse.getViewer().getCanvas3D().setVisible(false);
        simpleUniverse.removeAllLocales();
        
        locale = new Locale(simpleUniverse);
        vistas.setCapability(BranchGroup.ALLOW_CHILDREN_EXTEND);
        vistas.setCapability(BranchGroup.ALLOW_DETACH);
        locale.addBranchGraph(vistas);

    }
 
    public void addView(TransformGroup node_view){
        locale.removeBranchGraph(vistas);
        vistas.addChild(node_view);
        locale.addBranchGraph(vistas);
    }
    
    public BranchGroup createBackground(){
        
        Background background = new Background();
        BoundingSphere bound = new BoundingSphere (new Point3d (0.0, 0.0, 0.0), 100.0);
        background.setApplicationBounds(bound);
        
        Appearance apariencia = new Appearance();
        Texture text = new TextureLoader ("src/background/back.jpg" , null).getTexture();
        apariencia.setTexture(text);
        
        Sphere esfera = new Sphere(1.5f, Primitive.GENERATE_TEXTURE_COORDS |
                Primitive.GENERATE_NORMALS_INWARD, 500, apariencia );
        
        BranchGroup geometria = new BranchGroup();
        geometria.addChild(esfera);
        
        background.setGeometry(geometria);
        
        BranchGroup backgroundBranch = new BranchGroup ();
        backgroundBranch.addChild(background);
        
        // colgamos la luz ambiental al branchgroup
        LuzAmbiental la = new LuzAmbiental(new Color3f(0.8f,0.2f,0.2f));
        backgroundBranch.addChild(la);
        
        return backgroundBranch;
    }

}
