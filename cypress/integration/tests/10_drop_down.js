/////<reference types="cypress"/>
///// <reference types="cypress-xpath" />

import Login_Page from "../pages/Login_Page"
describe('login functionality', () => {


    const lp = new Login_Page()
    beforeEach(() => {
        cy.viewport("macbook-16")
        cy.visit(Cypress.config("her_oku"))
        lp.click(11)
    })

  

    it('TC0701	Url de drop and down oldugunu dogrulayiniz', () => {
        cy.get("#dropdown").should("exist")
    });



    it('TC0702	iki tane kutu oldugunu dogrula', () => {
        cy.xpath("//option[@value]").each((item, index, list) => {

            expect(list).to.have.length(3);

            //cy.wrap(item).should("contain.text")

        })
    });
    it('select 1', () => {
        //1.way
       // cy.get("#dropdown").select('1').should("have.value", "1")
        //2. way
       // cy.get("#dropdown").select("Option 1").should('have.value', '1')
        //3. way
        cy.get("#dropdown").select(1).should('have.value', '1')

    });

    it('select 2', () => {
        cy.get("#dropdown").select(2).should('have.value','2')
       //olmadi 
       // cy.get("#dropdown").select(2).should('have.text','Option 2')

    });


})
