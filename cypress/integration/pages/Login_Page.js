//////<reference types="cypress"/>

class Login_Page {

    visit() {
        cy.visit("http://the-internet.herokuapp.com/")
        return this
    }
    click(sira){
        const webElement= cy.get("li:nth-child("+sira+") > a")
      //  webElement.should('be.visible')
        webElement.click()
        return this
    }

    assert(){
        cy.url()
    }
}

export default Login_Page