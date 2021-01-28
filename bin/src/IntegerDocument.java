/*
Copyright 2020
Reboot ITS
Thomas Zenger (contact@thomas-zenger.de)

GNU GENERAL PUBLIC LICENSE


This program is free software: you can redistribute it and/or modify
    it under the terms of the GNU General Public License as published by
    the Free Software Foundation, either version 3 of the License, or
    (at your option) any later version.

    This program is distributed in the hope that it will be useful,
    but WITHOUT ANY WARRANTY; without even the implied warranty of
    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
    GNU General Public License for more details.

    You should have received a copy of the GNU General Public License
    along with this program.  If not, see <http://www.gnu.org/licenses/>.

    Dieses Programm ist Freie Software: Sie können es unter den Bedingungen
    der GNU General Public License, wie von der Free Software Foundation,
    Version 3 der Lizenz oder (nach Ihrer Wahl) jeder neueren
    veröffentlichten Version, weiter verteilen und/oder modifizieren.

    Dieses Programm wird in der Hoffnung bereitgestellt, dass es nützlich sein wird, jedoch
    OHNE JEDE GEWÄHR,; sogar ohne die implizite
    Gewähr der MARKTFÄHIGKEIT oder EIGNUNG FÜR EINEN BESTIMMTEN ZWECK.
    Siehe die GNU General Public License für weitere Einzelheiten.

    Sie sollten eine Kopie der GNU General Public License zusammen mit diesem
    Programm erhalten haben. Wenn nicht, siehe <https://www.gnu.org/licenses/>.
 */

import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;
import java.awt.*;

public class IntegerDocument extends PlainDocument {
    private static final long serialVersionUID = 1L;
    private int validLength;

    public IntegerDocument(int i) {
        this.validLength = i;
    }

    public int getLength() {
        return super.getLength();
    }

    public void insertString(int offset, String str, AttributeSet a) throws BadLocationException {
        String valid = "0123456789";

        for(int i = 0; i < str.length(); ++i) {
            if (valid.indexOf(str.charAt(i)) == -1 || this.getLength() + str.length() > this.validLength) {
                Toolkit.getDefaultToolkit().beep();
                return;
            }

            super.insertString(offset, str, a);
        }

    }
}