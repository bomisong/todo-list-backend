package com.scnu.todo

import com.tngtech.archunit.core.importer.ClassFileImporter
import com.tngtech.archunit.core.importer.ImportOption
import com.tngtech.archunit.lang.syntax.ArchRuleDefinition.noClasses
import org.junit.jupiter.api.Test

class ArchTest {

    @Test
    fun servicesAndRepositoriesShouldNotDependOnWebLayer() {

        val importedClasses = ClassFileImporter()
            .withImportOption(ImportOption.Predefined.DO_NOT_INCLUDE_TESTS)
            .importPackages("com.scnu.todo")

        noClasses()
            .that()
            .resideInAnyPackage("com.scnu.todo.service..")
            .or()
            .resideInAnyPackage("com.scnu.todo.repository..")
            .should().dependOnClassesThat()
            .resideInAnyPackage("..com.scnu.todo.web..")
            .because("Services and repositories should not depend on web layer")
            .check(importedClasses)
    }
}
