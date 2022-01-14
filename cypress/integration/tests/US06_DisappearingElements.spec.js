/// <reference types = "Cypress"/>

context("Login Senaryolari",()=>{

    beforeEach(() => {
        cy.visit("http://the-internet.herokuapp.com/disappearing_elements")
    })-

    it("Disappearing Elements sayfasinda 5 tane menu basligi oldugunu dogrulayiniz",()=>{
        
       
            // if (cy.get('ul>li>a').length>4) {
            //     cy.xpath("//a[.='Gallery']").should('be.visible') 
            // }else{
            //     break;
            
              
            //   }
       
    })
    
    it("Home menusune tiklandiginda anasayfaya gidildigini dogrulayiniz",()=>{
        cy.xpath("(//ul/li)[1]").click()

        cy.url().should('eq', 'http://the-internet.herokuapp.com/')

        //2. assert
         cy.xpath("//h1").should('be.visible')     
           
         //3.assert
           cy.xpath("//h1").invoke('text').then((text) =>{
            expect(text).contains('Welcome')
            cy.log(text)
       })
         
        

           
    })
})
   it("*About, Contact Us,Portfolio menulere tiklandiginda 'Not Found' mesajinin goruntulendigini dogrulayiniz",()=>{
       cy.visit("http://the-internet.herokuapp.com/disappearing_elements")

        // cy.get('ul>li').each((item, index, list) => {
        //     list.click()
        //     expect(list).to.should('have.text','Not Found')
       

       for (let i = 1; i <= 4; i += 1) {   
            cy.xpath('(//ul//li/a)['+i+']')
            .click()
            cy.xpath('//h1').should('be.visible')
            cy.go(-1)

         }
        

     
});

   /// })

    

it.only("Her bir menunun once kirmizi(#DA4B4B) renkte gorundugunu, mouse ile ustune gidildiginde siyah(#000) renge donustugunu dogrulayiniz",()=>{
 
    cy.visit("http://the-internet.herokuapp.com/disappearing_elements")
    cy.get('ul>li>a').each((item, index, list) => {
        cy.log("ElementName: " + item.text(), ", index: " + index, " , elemanSayisi: " + list.length)
       
        cy.get(item).should('have.css', 'color', 'rgb(218, 75, 75)') 
        cy.wait(1000)
       // item.trigger('mouseover').should('have.css', 'color', 'rgb(34, 34, 34)')
  

       

 for (let i = 1; i <= 4; i += 1) {   
     cy.xpath('(//ul/li/a)['+i+']').trigger('mouseover').should('have.css', 'color', 'rgb(218, 75, 75)')
    
   
 }
 })
})
 //})
   