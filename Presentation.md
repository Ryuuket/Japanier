---
marp: true
theme: default
paginate: true
---

# Japanier's entities

This document aims to present the application's data model. It details every used entities, their properties, relations to each others, and how this elements fit together to form the application's structure. 

---

## Entitie's definition


### User
id (UUID): A unique identifier for each user. It's a primary key.
email (string): The user's e-mail adress. It is used for authentication.
username (string) : The username chosen by the user, and used for communication on the platform.
password (string): The user's password. It is usef for authentication and is stored in a secured way.
role (string): The user's role. It defines what he is allowed to do in the application.
avatar (string): A link to the picture identifying the user. It appears on his profil and his messages.
description (string): The user's description, wrote by himself.
language (string): The language displayed to the user on the website.
createdAt (date): The timestamp at which the user was created.

---

### VideoLesson
id (UUID): A unique identifier for each lesson. It is a primary key.
title (string): The lesson's title.
link (string): A link to the video's lesson.
description (string): A description of the lesson's content.
createdAt (date): The timestamp at which the video lesson was created.

### Exercise
id (UUID): A unique identifier for each exercise. It is a primary key.
link (string): A link to the lesson's exercise.
description (string): A description of the exercise's content.
lesson (UUID): Lesson the exercise is linked to.
createdAt (date): The timestamp at which the video lesson was created.

---

### WatchedLesson
user (UUID): The identfier of the user who watched the lesson.
lesson (UUID): The identifier of the lesson watched by the user.
WatchedAt (date): The timestamp at which the lesson was watched.

### ExerciseResult
user (UUID): The identifier of the user who wrote answers to the exercise.
exercise (UUID): The identifier of the exercise that the user did.
note (float): Note of the user on the exercise.
doneAt (date): The timestamp at which the result was calculated.

---

## Relations between entities

In our application's data model, entities interacts with each others through various types of relations that reflects the application's business logic. Here's the relations' details :

---

### User-WatchedLesson (1:N)
- **Relation** : "watches"
- **Description** : A user may have watched zero, one or many lessons, and a watched lesson was watched by one single user. (1:N).
- **Implémentation** : The `WatchedLesson` table includes a foreign key `user` that references the primary key `id` from the `User` table.

### VideoLesson-WatchedLesson (1:N)
- **Relation** : "contains"
- **Description** : A watched lesson is a lesson, and lessons may have been watched zero, one or many times. (1:N).
- **Implémentation** : The `WatchedLesson` table includes a foreign key `lesson` that references the primary key `id` in the `VideoLesson` table.

---

### User-ExerciseResult (1:N)
- **Relation** : "owns"
- **Description** : A user has zero, one or many exercicse results saved, and a result has only one user.(1:N).
- **Implémentation** : The `ExerciseResult` table includes a foreign key `user` that references the foreign key `id` from the `User` table.

### Exercise-ExerciseResult (1:N)
- **Relation** : "belongs to"
- **Description** : An exercise can produce zero, one or many results, and a result concerns a single exercise. (1:N).
- **Implémentation** : The `ExerciseResult` table includes a foreign key `exercise` that references the primary key `id` from the `Exercise` table.

---

## Entities representation in a diagram

The diagrams are realised using [Entity Relationship Diagrams de mermaid](https://mermaid.js.org/syntax/entityRelationshipDiagram.html)

---

This one is the diagram showing the Minimum Valuable Product.

[![](https://mermaid.ink/img/pako:eNp9UkFuwyAQ_AriHH_At0rJoVJPrdJeuFDYOKh4N4K1nCrO3wsYNXZVmQtimJ1ZdrhJQxZkKyHsne6C7hUeIwQxTU1DN_Gh2ZzBvkCMhK1QcixAVFLh6k7cqWmmSbw7C1ShzDeErB2WgqXwK8TBc6HQOF9XqAodrhCMi1Aon-AJuyiYMrEq3RSKtI7H571wdj5EDg47Ab12foUMqQJ1DyvwomMcKdRaqxmECZA2-8QK79lp-Z4NQ3bs19re4dcMMFxZWIgmuAs7wg239UiXfrn_xdEXxkJpzuWh9Du-jaYfLf6v-be7GtBGW1BcTZ3EyZNmgcSwELWEUBTlTvYQUlA2fb-iqSSfIUUkc-QWTjq55bwzVQ9Mb99oZMthgJ0cLlmt_tkZvP8AEtT0Cw?type=png)](https://mermaid.live/edit#pako:eNp9UkFuwyAQ_AriHH_At0rJoVJPrdJeuFDYOKh4N4K1nCrO3wsYNXZVmQtimJ1ZdrhJQxZkKyHsne6C7hUeIwQxTU1DN_Gh2ZzBvkCMhK1QcixAVFLh6k7cqWmmSbw7C1ShzDeErB2WgqXwK8TBc6HQOF9XqAodrhCMi1Aon-AJuyiYMrEq3RSKtI7H571wdj5EDg47Ab12foUMqQJ1DyvwomMcKdRaqxmECZA2-8QK79lp-Z4NQ3bs19re4dcMMFxZWIgmuAs7wg239UiXfrn_xdEXxkJpzuWh9Du-jaYfLf6v-be7GtBGW1BcTZ3EyZNmgcSwELWEUBTlTvYQUlA2fb-iqSSfIUUkc-QWTjq55bwzVQ9Mb99oZMthgJ0cLlmt_tkZvP8AEtT0Cw)

---

## Règles Métier

### Création de compte utilisateur

[![](https://mermaid.ink/img/pako:eNqVk01OwzAQha8y8oZNuUAWSLRBohK7KKyysewJNXLs4J-qqOIuLMk5cjHGiYEINUh4lfh9Mx6_GZ-ZsBJZwTy-RDQCS8WfHO8aA7S4CNZBDdxDHZRWngeMbtZ67oISqucmQL1PyN4EdC0X-DdcJbZCd7yoltskb7lHkAilNWYc0DdmJuvrm5t6X8DuYNUpAcKR7CAaELbrA2ZsT1xVQIkdNxK_QB6UNdPPxAI_ogBClAYM0NmQtJ57n9NUlKXcFvA4Dk61CsEr0Fc54KQ8pZDj8Dy-Z7d0gId1Oa1yOxd2N0GzCnFyaxx-sCpf87ZtlTggoHNkFsicfDVuunf9vzjUZPV32T6Ql4pGYa3mWSUHTatc97towu55OlnjBT-Xnu5S4xJmbDyizkUtRmZ59G4-7ad_y2bqq4uxXx4uZnGKG4e57z4KMX74dfMysDI82Twj2YZ1SLUpSa_onLYbFg7YYcMK-pTY8qhDwxrzRiiPwVavRrAiuIgbFntJpeVHN2--fQIuJTmf?type=png)](https://mermaid.live/edit#pako:eNqVk01OwzAQha8y8oZNuUAWSLRBohK7KKyysewJNXLs4J-qqOIuLMk5cjHGiYEINUh4lfh9Mx6_GZ-ZsBJZwTy-RDQCS8WfHO8aA7S4CNZBDdxDHZRWngeMbtZ67oISqucmQL1PyN4EdC0X-DdcJbZCd7yoltskb7lHkAilNWYc0DdmJuvrm5t6X8DuYNUpAcKR7CAaELbrA2ZsT1xVQIkdNxK_QB6UNdPPxAI_ogBClAYM0NmQtJ57n9NUlKXcFvA4Dk61CsEr0Fc54KQ8pZDj8Dy-Z7d0gId1Oa1yOxd2N0GzCnFyaxx-sCpf87ZtlTggoHNkFsicfDVuunf9vzjUZPV32T6Ql4pGYa3mWSUHTatc97towu55OlnjBT-Xnu5S4xJmbDyizkUtRmZ59G4-7ad_y2bqq4uxXx4uZnGKG4e57z4KMX74dfMysDI82Twj2YZ1SLUpSa_onLYbFg7YYcMK-pTY8qhDwxrzRiiPwVavRrAiuIgbFntJpeVHN2--fQIuJTmf)

---

### Suivi d'un cours

[![](https://mermaid.ink/img/pako:eNp9VEtu4zAMvQqhTTdND-BFgaaeRYBZjeGusmElutFAljz6BB0Uvctscw5fbCjLSdykrVeC-fj4-ETqTUinSFQi0J9EVlKt8cVjv7XAH8roPLSAAdqojQ4YKfkSG9BHLfWANkK7yZCNjeQ7lPQ9uMnYhvz-02i9zuE1BgJFUDtrxwOFgptFmQg_b9K5BCAkC9L1QySgCMGlHWo-M4dkApKs664kt6v7-3ZTwePO6ddcYYmZIRvGNBXU1KNVk4wZoZ0F3JMEjmiTS_Uu5viAIVDJblacXa8reBoPXneagH0FQwG0Iht11NxlYEbvKQzO5p8ls16vSuFHZzvt-2VWN2UtKuQentBwFAwWfa8s79RBhlTw0HVa7hhyg1ImYs2TfPPBvbm58VCSyaql20fDjm6M_2DvtJ-0SZd8AKVzH_rZHK_p0kAWyMVidnLOubDqa-A1ObtUyLPqnBGRg59ST7InWMrQE7N7_k3xA_zasC8kt0feZjyYMhET_ayWzfH0gl4tZumKeK_VeHCg0pL4eqgpxPPV3C3puPuHPfHKTLPHjJ2286lwX9j7w7Io7sYvy_O68IQVtbxheQdB8kSny9U9zUM7t_KrdHjmEreiJ88rofgdecvgrYg76mkrKj4q6jCZuBVb-85QTNE1f60UVfSJbkUaFFebnx1RdWgCvf8H4y6Mbg?type=png)](https://mermaid.live/edit#pako:eNp9VEtu4zAMvQqhTTdND-BFgaaeRYBZjeGusmElutFAljz6BB0Uvctscw5fbCjLSdykrVeC-fj4-ETqTUinSFQi0J9EVlKt8cVjv7XAH8roPLSAAdqojQ4YKfkSG9BHLfWANkK7yZCNjeQ7lPQ9uMnYhvz-02i9zuE1BgJFUDtrxwOFgptFmQg_b9K5BCAkC9L1QySgCMGlHWo-M4dkApKs664kt6v7-3ZTwePO6ddcYYmZIRvGNBXU1KNVk4wZoZ0F3JMEjmiTS_Uu5viAIVDJblacXa8reBoPXneagH0FQwG0Iht11NxlYEbvKQzO5p8ls16vSuFHZzvt-2VWN2UtKuQentBwFAwWfa8s79RBhlTw0HVa7hhyg1ImYs2TfPPBvbm58VCSyaql20fDjm6M_2DvtJ-0SZd8AKVzH_rZHK_p0kAWyMVidnLOubDqa-A1ObtUyLPqnBGRg59ST7InWMrQE7N7_k3xA_zasC8kt0feZjyYMhET_ayWzfH0gl4tZumKeK_VeHCg0pL4eqgpxPPV3C3puPuHPfHKTLPHjJ2286lwX9j7w7Io7sYvy_O68IQVtbxheQdB8kSny9U9zUM7t_KrdHjmEreiJ88rofgdecvgrYg76mkrKj4q6jCZuBVb-85QTNE1f60UVfSJbkUaFFebnx1RdWgCvf8H4y6Mbg)

---

### Réalisation d'un exercice

[![](https://mermaid.ink/img/pako:eNqNVUtu2zAQvQqhjTfxBbQIUFctYCCrCsrKmwk1cthSpMqPkSLIXbrVOXSxDklLtiXbjReGoJk38-a9IfWecV1jlmcWf3tUHAsBewPtTjH6AXfasIqBZZUTUlhw6E2KdWCc4KID5Vi1DSlb5dA0wPF-chlySzSHq9FiE8IbsMhqZIVWaujRprz0X60fH6ttTiUYpzBy6nqMbClU5qzAFlQdCxwzhFYMDsgZRYRk6FirXYh3YC0mdLkmdLHJ2fPQG9EIZKQIk2iZqFE54QTxs1TRGLSdVuFlQhabdWr8VatGmPYc1UTUWYdA_RkkRZmExO-N6E0ThJScfWkawV8pZQWceyTOkb5c-ZO043BDfynMOP7wlx20MJEMvqHhgtNTLQJ58SJHVeeqESvq4IJ8Z7iZRveTl01IotQkUA4oBxS82SKOEVN9SJ866Jef6BaQpWp3RqjG-uXQy7Qasc2UF3QzQ08W2bPFWjToYB83TK5G4Kz-04VXtAsmTUO1SZtx61JpUuYpEg5ejQk2gsL6hxNy6f3Mjm_K4J4KmLgxB6CD3BL4Gj-QbkbNYGdQ1YvMaa2Ppk1hKhvcH_pwkGxY4raTQ59OGXcepcS7lE_2RiGNY4qgYxma-Kqwt0yI10fseQVFg818-S6UcDeql0FKOjRzI2Lh67OEYw-SezlhrJcO3F1Q8Kx0mv_6L4hZbxZkJxF_4Mg23ktiT558SrqTl2ThxazZQ9aioWuypq_Ce8DvMvdK67TLcnqssQGiust26oNSwTtd_lE8y53x-JD5ribax49IljcgLX78A1iZLhQ?type=png)](https://mermaid.live/edit#pako:eNqNVUtu2zAQvQqhjTfxBbQIUFctYCCrCsrKmwk1cthSpMqPkSLIXbrVOXSxDklLtiXbjReGoJk38-a9IfWecV1jlmcWf3tUHAsBewPtTjH6AXfasIqBZZUTUlhw6E2KdWCc4KID5Vi1DSlb5dA0wPF-chlySzSHq9FiE8IbsMhqZIVWaujRprz0X60fH6ttTiUYpzBy6nqMbClU5qzAFlQdCxwzhFYMDsgZRYRk6FirXYh3YC0mdLkmdLHJ2fPQG9EIZKQIk2iZqFE54QTxs1TRGLSdVuFlQhabdWr8VatGmPYc1UTUWYdA_RkkRZmExO-N6E0ThJScfWkawV8pZQWceyTOkb5c-ZO043BDfynMOP7wlx20MJEMvqHhgtNTLQJ58SJHVeeqESvq4IJ8Z7iZRveTl01IotQkUA4oBxS82SKOEVN9SJ866Jef6BaQpWp3RqjG-uXQy7Qasc2UF3QzQ08W2bPFWjToYB83TK5G4Kz-04VXtAsmTUO1SZtx61JpUuYpEg5ejQk2gsL6hxNy6f3Mjm_K4J4KmLgxB6CD3BL4Gj-QbkbNYGdQ1YvMaa2Ppk1hKhvcH_pwkGxY4raTQ59OGXcepcS7lE_2RiGNY4qgYxma-Kqwt0yI10fseQVFg818-S6UcDeql0FKOjRzI2Lh67OEYw-SezlhrJcO3F1Q8Kx0mv_6L4hZbxZkJxF_4Mg23ktiT558SrqTl2ThxazZQ9aioWuypq_Ce8DvMvdK67TLcnqssQGiust26oNSwTtd_lE8y53x-JD5ribax49IljcgLX78A1iZLhQ)