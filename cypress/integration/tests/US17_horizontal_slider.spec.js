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

it.only('keyboard move', () => {
   // cy.get('input[type=range]').type('{rightarrow}')

    cy.get('input[type=range]').as('m').trigger('mouseright')

});