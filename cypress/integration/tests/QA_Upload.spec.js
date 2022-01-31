///<reference types = "Cypress"/>

context("Upload", () => {
    it("File Upload", () => {
        cy.visit("https://the-internet.herokuapp.com/")
        cy.get("[href='\/upload']").click()
        // cy.visit("https://the-internet.herokuapp.com/upload")
        cy.get("input#file-upload").attachFile("CYPRESSNOTLAR.txt")
        cy.get('input#file-submit').click()
        cy.get('div#uploaded-files').should("a.text", "CYPRESSNOTLAR")//input'un altindaki "label"tagnagme'den 
        //lokate aliyoruz cunku orada yuklenen dosyanin ismi olusuyor.  // should oder cointains besser als??
    })


    /*
        it("File Upload", () => {
            cy.visit("https://the-internet.herokuapp.com/upload")
            cy.get("input#file-upload").attachFile("typing.gif")
            cy.get('input#file-submit').click()
            cy.get('div#uploaded-files').should("include.text", "typing")
        })
        /*
            it("File Upload 2",()=>{
               //2.YONTEM hazir method kullanarak upload yapmak (Method'daki dosya uzantisina dikkatt!!)
               cy.visit("https://the-internet.herokuapp.com/")
               cy.UploadImage("#exampleInputFile","C:\Users\Muaz\Desktop\typing.gif","typing")
               cy.get('.input-group [for]').should("include.text","typing")
    
           })*/
})

//DIKKAT!!!! Dosyayi Upload etmeye baslamadan once  bir install 2 import islemimiz var.
   //1.  Terminale   npm install --save-dev cypress-file-upload  yapistirip enterliyoruz
   //2.  cypress/support/commands.js sayfasina  import 'cypress-file-upload';  yapistiriyoruz
   //3.  cypress/support/index.js   sayfasina   import './commands';   yapistiriyoruz.