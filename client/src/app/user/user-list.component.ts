import {Component, OnInit, ViewChild} from '@angular/core';
import {UserService} from '../shared/service/user.service';
import {MatPaginator, MatSort, MatTableDataSource} from '@angular/material';
import {User} from '../shared/model/user.model';

@Component({
  selector: 'app-user-list',
  templateUrl: './user-list.component.html'
})
export class UserListComponent implements OnInit {
  users: Array<any>;

  displayedColumns = ['id', 'username', 'password', 'enabled', 'registerDate', 'name', 'surname', 'email', 'phone'];

  dataSource: MatTableDataSource<User>;

  @ViewChild(MatPaginator) paginator: MatPaginator;
  @ViewChild(MatSort) sort: MatSort;

  constructor(private service: UserService) {
  }

  configurePaginationAndSort() {
    this.dataSource.paginator = this.paginator;
    this.dataSource.sort = this.sort;
  }

  ngOnInit() {
    this.service.getAll().subscribe(data => {
      this.users = data;
      this.dataSource = new MatTableDataSource(this.users);
      this.configurePaginationAndSort();
    });
  }

  applyFilter(filterValue: string) {
    filterValue = filterValue.trim(); // Remove whitespace
    filterValue = filterValue.toLowerCase(); // Datasource defaults to lowercase matches
    this.dataSource.filter = filterValue;
  }


}
