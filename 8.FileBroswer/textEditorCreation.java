// package FileBroswer_8;

// public if (!file.isDirectory()) {

//     footerInfoLabel.setText(" File size : " + file.length() + " bytes");
//     footerInfoLabel.setIcon(fileSystemView.getSystemIcon(file));
//     String fileType = "Undetermined";

//     try {
//         fileType = Files.probeContentType(file.toPath());
//     } 
    
//     catch (IOException ioException) {
//         fileType = "Undetermined";
//         System.out.println("!! ERROR: " + ioException);
//     }

    
//     if (fileType == null)
//         fileType = "Undetermined";

//     // ----------------------------------------------------------------
//     // ----------------------------------------------------------------
//     // This is for Opening the ".txt" files "text/plain"
//     // ----------------------------------------------------------------
//     // ----------------------------------------------------------------
//     if (fileType.toString().equals("text/plain")) {   
//     // || if (fileType.toString().equals("application/pdf")){

//         if (fileType.toString().equals("text/plain"))
//             textArea = new JTextArea(readFile(file.toString()));
//         else
//             textArea = new JTextArea(readPdf(currentFolder));

//         // ----------------------------------------------------------------
//         // ----------------------------------------------------------------
//         // This is for the Color and Background and Font of the ".txt" files
//         // ----------------------------------------------------------------
//         // ----------------------------------------------------------------
//         textArea.setBackground(Color.LIGHT_GRAY);
//         textArea.setForeground(Color.black);
//         textArea.setFont(new Font("Tahoma", Font.BOLD, 35));
//         // ---------------------------------------------------------------
//         // ---------------------------------------------------------------

//         showScrollPane = new JScrollPane();
//         showScrollPane.getViewport().add(textArea, BorderLayout.CENTER);
//         showScrollPane.setPreferredSize(showPanel.getSize());
//         showScrollPane.validate();
//         showPanel.add(showScrollPane, BorderLayout.CENTER);
//         showPanel.validate();
//     }  {
    
// }
