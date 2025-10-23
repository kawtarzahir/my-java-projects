/*
🕵️‍♂️ Detective Case Management System

Mission:

Build a system to manage detective cases in a crime agency.

Classes and their responsibilities:

1. Enum Status:
   - Represents the status of a case.
   - Values: OPEN, IN_PROGRESS, CLOSED.

2. Class Case:
   - Fields:
     - int caseId (unique identifier)
     - String title
     - String description
     - Status status
     - List<String> suspects
   - Constructor to initialize all fields (status starts as OPEN).
   - Getters for all fields.
   - Method to add a suspect to the suspects list.
   - Method to change the case status.

3. Class Detective:
   - Fields:
     - int detectiveId (unique identifier)
     - String name
     - List<Case> assignedCases
   - Constructor to initialize detectiveId and name.
   - Getters for detective info.
   - Methods to assign a case to the detective (add to assignedCases).
   - Method to get list of assigned cases.

4. Class Agency:
   - Fields:
     - Collection of detectives
     - Collection of cases
   - Methods:
     - addCase(Case c): adds a case if not already present (by caseId).
     - addDetective(Detective d): adds a detective if not already present (by detectiveId).
     - assignCaseToDetective(int caseId, int detectiveId): assigns case to detective and marks case IN_PROGRESS.
     - closeCase(int caseId): sets case status to CLOSED.
     - getCasesByDetective(int detectiveId): returns list of cases assigned to that detective.
     - getOpenCases(): returns list of all cases with status OPEN.

Note: Uniqueness of cases and detectives is ensured by their IDs.

This design models multiple classes with collections and interactions, good practice for OOP and managing relationships.

*/

import java.util.ArrayList;
import java.util.List;

// Enum representing case status

enum Status {
    OPEN,
    IN_PROGRESS,
    CLOSED
}

// Represents a detective case

class Case {
    private int caseId;
    private String title;
    private String description;
    private Status status;
    private List<String> suspects;

    public Case(int caseId, String title, String description) {
        this.caseId = caseId;
        this.title = title;
        this.description = description;
        this.status = Status.OPEN;   // Cases start as OPEN
        this.suspects = new ArrayList<>();
    }

    public int getCaseId() {
        return caseId;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public Status getStatus() {
        return status;
    }

    public List<String> getSuspects() {
        return new ArrayList<>(suspects);  // Return copy to protect encapsulation
    }

    // Add a suspect to the list
  
    public void addSuspect(String suspect) {
        suspects.add(suspect);
    }

    // Change the case status
  
    public void setStatus(Status status) {
        this.status = status;
    }
}

// Represents a detective

class Detective {
    private int detectiveId;
    private String name;
    private List<Case> assignedCases;

    public Detective(int detectiveId, String name) {
        this.detectiveId = detectiveId;
        this.name = name;
        this.assignedCases = new ArrayList<>();
    }

    public int getDetectiveId() {
        return detectiveId;
    }

    public String getName() {
        return name;
    }

    // Assign a case to this detective
  
    public void assignCase(Case c) {
        assignedCases.add(c);
    }

    // Get cases assigned to this detective
  
    public List<Case> getAssignedCases() {
        return new ArrayList<>(assignedCases); // Return copy for safety
    }
}

// Agency that manages detectives and cases

class Agency {
    private List<Detective> detectives;
    private List<Case> cases;

    public Agency() {
        this.detectives = new ArrayList<>();
        this.cases = new ArrayList<>();
    }

    // Add a case if not already present (by caseId)
  
    public boolean addCase(Case c) {
        for (Case existing : cases) {
            if (existing.getCaseId() == c.getCaseId()) {
                return false; // Case with this ID already exists
            }
        }
        cases.add(c);
        return true;
    }

    // Add a detective if not already present (by detectiveId)
  
    public boolean addDetective(Detective d) {
        for (Detective existing : detectives) {
            if (existing.getDetectiveId() == d.getDetectiveId()) {
                return false; // Detective with this ID already exists
            }
        }
        detectives.add(d);
        return true;
    }

    /*
    Assign a case to a detective by their IDs.

    - Find case and detective.
    - If both found, assign the case to detective and set case status to IN_PROGRESS.
    - Returns true if successful, false otherwise.
    */
  
    public boolean assignCaseToDetective(int caseId, int detectiveId) {
        Case c = null;
        Detective d = null;

        // Find case
      
        for (Case cs : cases) {
            if (cs.getCaseId() == caseId) {
                c = cs;
                break;
            }
        }

        // Find detective
      
        for (Detective dt : detectives) {
            if (dt.getDetectiveId() == detectiveId) {
                d = dt;
                break;
            }
        }

        if (c != null && d != null) {
            d.assignCase(c);
            c.setStatus(Status.IN_PROGRESS);
            return true;
        }
        return false;
    }

    // Close a case by setting its status to CLOSED
  
    public boolean closeCase(int caseId) {
        for (Case c : cases) {
            if (c.getCaseId() == caseId) {
                c.setStatus(Status.CLOSED);
                return true;
            }
        }
        return false;
    }

    // Get all cases assigned to a detective by detectiveId
  
    public List<Case> getCasesByDetective(int detectiveId) {
        for (Detective d : detectives) {
            if (d.getDetectiveId() == detectiveId) {
                return d.getAssignedCases();
            }
        }
        return new ArrayList<>(); // Empty list if detective not found
    }

    // Get all open cases
  
    public List<Case> getOpenCases() {
        List<Case> openCases = new ArrayList<>();
        for (Case c : cases) {
            if (c.getStatus() == Status.OPEN) {
                openCases.add(c);
            }
        }
        return openCases;
    }
}
