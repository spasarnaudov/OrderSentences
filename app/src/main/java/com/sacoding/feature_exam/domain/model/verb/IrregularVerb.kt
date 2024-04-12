package com.sacoding.feature_exam.domain.model.verb

class IrregularVerb(
    override val baseForm: String,
    override val pastTense: String = baseForm,
    override val pastParticiple: String = baseForm,
): Verb(
    baseForm = baseForm,
    pastTense = pastTense,
    pastParticiple = pastParticiple,
)