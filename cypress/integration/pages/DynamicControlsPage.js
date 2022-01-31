class DynamicControlsPage{

    checkbox(){
        return cy.get("#checkbox>input")
    }

    generalMessage(){
        return cy.get("#message")
    }

    loadingMessage(){
        return cy.get("#loading")
    }

    remove_add_button(){
        return cy.get("#checkbox-example>button")
    }

    enable_disable_button(){
        return cy.get("#input-example>button")
    }

    input_enable_button(){
        return cy.get("#input-example>input")

}
}
export default DynamicControlsPage