import re
from bs4 import BeautifulSoup
import requests

def main():
    website_scraped = requests.get("https://www.oorth.com/astronomy/moon/phase/united-states/ames/")
    soup = BeautifulSoup(website_scraped.text, "html.parser")
    data = soup.find("b", attrs={"style":"font-size:12px;"})
    s = str(data)
    s = s.removeprefix('<b style="font-size:12px;">').removesuffix('</b>')
    print(s)
main()
