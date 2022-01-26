import *as A_B_TestingPage from '..//pages/A_B_TestingPage.spec'

describe("A/B Test", ()=>{
 
    it('Verify the title and description', () => {
        // Page Object Model'a gore yapildi. Export ve import kullanildi.
        const descriptionExpText="\n    Also known as split testing. This is a way in which businesses are able to simultaneously test and learn different versions of a page to see which text and/or functionality works best towards a desired outcome (e.g. a user action such as a click-through)."
        A_B_TestingPage.visitPage()

        cy.get(A_B_TestingPage.abTestLinkCSS).click({force:true})
        
        cy.url().should('eq','https://the-internet.herokuapp.com/abtest')
        
    
        //cy.xpath(titleXpath).should('have.text','A/B Test Variation 1')|| cy.xpath(titleXpath).should('have.text','A/B Test Control')
        cy.get(A_B_TestingPage.descriptionCSS).should('have.text',A_B_TestingPage.descriptionExpText)
        
    });
    it('assert that "Elemental Selenium" AND "Fork me on GitHub" are clickable', () => {
      const ForkMeOnGitHubXpath="//a[@href='https://github.com/tourdedave/the-internet']"
      const ElementelSeleniumXpath="//a[@target]"
      cy.xpath(ForkMeOnGitHubXpath).should('have.attr','href', 'https://github.com/tourdedave/the-internet')
      cy.xpath(ElementelSeleniumXpath).should('have.attr','href', 'http://elementalselenium.com/')
      
    });
    
    it.skip('assert that "Elemental Selenium" link is clickable', () => {
            const ElementelSeleniumXpath="//a[@target]"
            
            cy.xpath(ElementelSeleniumXpath).invoke('removeAttr','target').click()  
            cy.url().should('eq','http://elementalselenium.com/')  
    });
    
    it.skip('assert that "Fork me on GitHub" link is clickable', () => {
      const ForkMeOnGitHubXpath="//a[@href='https://github.com/tourdedave/the-internet']"
    
            cy.xpath(ForkMeOnGitHubXpath).invoke('removeAttr','target').click({force:true})
            cy.get("#code-tab").should('be.visible')
            // cy.url().should('eq','https://github.com/saucelabs/the-internet')
            cy.url().should('eq','https://github.com/saucelabs/the-internet')
    });
    
    
    })