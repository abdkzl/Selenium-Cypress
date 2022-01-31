
import DynamicControlsPage from '..//pages/DynamicControlsPage'

/////<reference types="Cypress"/>

const dynamicPage = new DynamicControlsPage();

context("Dynamic Controls",()=>{
    
   

    beforeEach(()=>{

        cy.visit("https://the-internet.herokuapp.com/dynamic_controls")
    })
    
    it('checkboxTest', () => {
        //dynamicPage.checkbox().click({force:true}); //bu da calisiyor
        dynamicPage.checkbox().check()
        dynamicPage.checkbox().should('be.checked')

        dynamicPage.remove_add_button().should('have.text','Remove')
        dynamicPage.remove_add_button().click()

        dynamicPage.loadingMessage().should('have.text','Wait for it... ')
        dynamicPage.generalMessage().should('have.text',"It's gone!")

        dynamicPage.remove_add_button().should('have.text','Add')
        dynamicPage.remove_add_button().click()
        dynamicPage.loadingMessage().should('have.text','Wait for it... ')
        dynamicPage.generalMessage().should('have.text',"It's back!")

        dynamicPage.remove_add_button().should('have.text','Remove')
       
    });

it.only('enabled_disabledButtonTest', () => {
    dynamicPage.input_enable_button().should('be.disabled')
    dynamicPage.enable_disable_button().click();
    dynamicPage.loadingMessage().should('have.text','Wait for it... ')

    dynamicPage.input_enable_button().should('be.enabled')
    dynamicPage.generalMessage().should('have.text',"It's enabled!")
    dynamicPage.input_enable_button().type('Test Passed')

    
    // dynamicPage.input_enable_button().invoke('val').then((ssss)=>{
    //     cy.log(ssss)

    //     let text=ssss
    //     cy.log(text)
    
    // })
    // assert.equal(dynamicPage.input_enable_button().invoke('val'),"Test Passed") 
    
    
    dynamicPage.enable_disable_button().should('have.text','Disable')

    dynamicPage.enable_disable_button().click()
    dynamicPage.loadingMessage().should('have.text','Wait for it... ')
    dynamicPage.input_enable_button().should('not.be.enabled')
    dynamicPage.generalMessage().should('have.text',"It's disabled!")
    dynamicPage.enable_disable_button().should('have.text','Enable')
});



})
