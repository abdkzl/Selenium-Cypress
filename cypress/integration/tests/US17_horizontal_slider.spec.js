 /// <reference types = "Cypress"/>
import *as A_B_TestingPage from '..//pages/A_B_TestingPage.spec'
import Login_Page from '../pages/Login_Page'

const lp = new Login_Page()
beforeEach(() => {
    cy.viewport("macbook-16")
    cy.visit(Cypress.config("her_oku"))
    lp.click(24)
})



it('TC17 title i dogrulayiniz', () => {
    cy.get("#content > div > h3").should("exist").should('contain','Horizontal Slider')
});

it('keyboard move', () => {
   // cy.get('input[type=range]').type('{rightarrow}')

    cy.get('input[type=range]').as('m').trigger('mouseright')

});

it('trigger ile', () => {

    


    cy.get('input[type=range]').invoke("val","0.5").trigger("change")
    cy.get('span[id=range]').should('contain.text','0.5')

    cy.get('input[type=range]').invoke("val","1").trigger("change")
    cy.get('span[id=range]').should('contain.text','1')

    cy.get('input[type=range]').invoke("val","1.5").trigger("change")
    cy.get('span[id=range]').should('contain.text','1.5')

    cy.get('input[type=range]').invoke("val","2").trigger("change")
    cy.get('span[id=range]').should('contain.text','2')

    cy.get('input[type=range]').invoke("val","3.5").trigger("change")
    cy.get('span[id=range]').should('contain.text','3.5')

    cy.get('input[type=range]').invoke("val","4").trigger("change")
    cy.get('span[id=range]').should('contain.text','4')

    cy.get('input[type=range]').invoke("val","4.5").trigger("change")
    cy.get('span[id=range]').should('contain.text','4.5')

    cy.get('input[type=range]').invoke("val","5").trigger("change")
    cy.get('span[id=range]').should('contain.text','5')

});

it('keyboard', () => {
    cy.get('input[type=range]').type('{leftarrow}').trigger("change")
    cy.get('span[id=range]').should('contain.text','0.5')
});

it.only('keyboard', () => {
  //  cy.get('input[type=range]').trigger('mousemove',{which: 1, pageX: 600,pageY:300})
  cy.get('input').trigger('mouseup',30,0)
    cy.get('span[id=range]').should('contain.text','0.5')
});