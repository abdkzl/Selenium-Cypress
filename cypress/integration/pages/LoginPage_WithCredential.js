//////<reference types="cypress"/>

const username = "tomsmith"
const password = "SuperSecretPassword!"


class LoginPage_WithCredential {


    visit() {
        cy.visit("https://the-internet.herokuapp.com/login")
        return this
    }

    visitAssertion() {
        cy.xpath("//h2[text()='Login Page']").should('have.text', 'Login Page')


        cy.xpath("//h2[text()='Login Page']").invoke('text').then((pageText) => {
            cy.log(pageText)



        })

    }

    login() {

        // cy.get("input[type='text']").type(username)
        // cy.get("input[type='password']").type(password)
        // cy.get("button[type='submit']").click()

        cy.fixture("login_credentials").then((user) => {


            cy.get("input[name='username']").type(user.username)
            cy.get("input[name='password']").type(user.userPassword)
            cy.get("button[type='submit']").click()



        })



    }
    loggedAssertion() {
        cy.get("#flash").should('include.text', 'You logged into a secure area!')
        cy.get("#flash").invoke('text').then((textmessage) => {
            cy.log(textmessage)
        })

        cy.xpath("//h2[normalize-space()='Secure Area']").should('include.text', 'Secure Area')
        cy.xpath("//h2[normalize-space()='Secure Area']").invoke('text').then((pageTitle) => {
            cy.log(pageTitle)
        })


    }

    logout() {
        cy.get(".icon-2x.icon-signout").click()
    }

    logoutAssertion() {
        cy.get("#flash").should("include.text", "You logged out of the secure area!")
        cy.get("#flash").invoke('text').then((message) => {
            cy.log(message)
        })
    }

    loginInvalidCredentials() {
        cy.fixture("login_credentials").then((user) => {

            cy.get("input[name='username']").type(user.fakeUser)
            cy.get("input[name='password']").type(user.fakePassword)
            cy.get("button[type='submit']").click()

        })
        cy.get("#flash").should("include.text", " Your username is invalid!")


    }

    cssAssertion(){
        cy.get(".radius").should('have.css','background-color','rgb(43, 166, 203)')
        cy.get(".radius").trigger('mouseover').should('have.css','box-shadow','rgba(255, 255, 255, 0.5) 0px 1px 0px 0px inset')
        cy.get(".radius").should('have.css','background-color','rgb(43, 166, 203)')
    }




}
export default LoginPage_WithCredential