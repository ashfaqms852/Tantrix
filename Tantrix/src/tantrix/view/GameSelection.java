/**
 * 
 */
package tantrix.view;

//import java.awt.BorderLayout;

//import java.awt.event.MouseEvent;

import javax.swing.JFrame;

/**
 * @author Narendran
 *
 */
public class GameSelection extends javax.swing.JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	//jComponents Declaration
	javax.swing.JButton jButton1;
	javax.swing.JButton jButton2;
	javax.swing.JButton jButton3;
	
	public GameSelection gsSingleton;
	/*public GameSelection getInstance(){
		if(gsSingleton==null){
			gsSingleton = new GameSelection();
		}
		return gsSingleton;
	}*/
	
	GameSelection() {
		initFrame();
	}
	
	void initFrame(){
		jButton1 = new javax.swing.JButton();
		jButton2 = new javax.swing.JButton();
		jButton3 = new javax.swing.JButton();
		//jButton1.setLocation(0,0);
		//jButton1.setSize(100,100);
		jButton1.setText("Discovery Game");
		jButton2.setText("Solitaire Game");
		jButton3.setText("Quit");
		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(122, 122, 122)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addContainerGap(135, Short.MAX_VALUE))
        );//ending of horizontal group
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(100, 100, 100)
                    .addComponent(jButton1)
                    .addGap(39, 39, 39)
                    .addComponent(jButton2)
                    .addGap(39, 39, 39)
                    .addComponent(jButton3)
                    .addContainerGap(115, Short.MAX_VALUE))
        );//end of vertical group
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
		jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
		jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
		setTitle("Select your choice");
		pack();
	}
	
	
	public void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {
		String[] args = new String[2];
		DiscoveryMain.main(args);// dm = new DiscoveryMain();
		//dm.setVisible(true);
		this.setVisible(false);

	}
	
	public void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {
		String[] args = new String[2];
		SolitaireMain.main(args);// sm = new SolitaireMain();
		//sm.setVisible(true);
		this.setVisible(false);
	}
	
	public void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {
		System.exit(0);
	}

}
